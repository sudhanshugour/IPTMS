package com.sud.zuul.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sud.zuul.exception.ProductNotFoundException;
import com.sud.zuul.exception.UserMisMatch;
import com.sud.zuul.model.Product;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private RestTemplate restTemplate;

	/////////////////////////////////////////////////////////////////////////////////////// ++

	@GetMapping("/product/get/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> getProductById(Principal principal, @PathVariable long id) {
		LOGGER.info("Start");
		String adminId = principal.getName();

		ResponseEntity<String> response = null;

		try {
			response = restTemplate.getForEntity("http://zuul-api/product/admin/products/get/" + adminId + "/" + id,
					String.class);
		} catch (Exception e) {
			throw new ProductNotFoundException(id);
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;
	}

	///////////////////////////////////////////////////////////////////////////////////// +++++++

	@GetMapping("/product/get-all")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> getProductsByAdminId(Principal principal) {
		LOGGER.info("Start");
		String adminId = principal.getName();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity("http://zuul-api/product/admin/products/get-all/" + adminId,
					String.class);

		} catch (Exception e) {
			throw new ProductNotFoundException();
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;
	}

	////////////////////////////////////////////////////////////////////////////////////////////// +++++++

	@GetMapping("/product/get-by-status/{status}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> getProductsByAdminIdAndStatus(Principal principal, @PathVariable String status) {
		LOGGER.info("Start");
		String adminId = principal.getName();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(
					"http://zuul-api/product/admin/products/get-by-status/" + adminId + "/" + status, String.class);
		} catch (Exception e) {
			throw new ProductNotFoundException();
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/product/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addProduct(Principal principal, @RequestBody Product product) {
		LOGGER.info("Start");
		String adminId = principal.getName();

		if (!adminId.equals(product.getAdminId())) {
			throw new UserMisMatch(adminId, product.getAdminId());
		}
		HttpEntity<Product> request = new HttpEntity<>(product);
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.postForEntity("http://zuul-api/product/admin/products/add", request, String.class);

		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PutMapping("/product/update")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> updateProductById(Principal principal, @RequestBody Product product) {
		LOGGER.info("Start");
		String adminId = principal.getName();
		if (!adminId.equals(product.getAdminId())) {
			throw new UserMisMatch(adminId, product.getAdminId());
		}
		ResponseEntity<String> response = new ResponseEntity<>("item updated", HttpStatus.OK);

		try {
			restTemplate.getForEntity("http://zuul-api/product/admin/products/get/" + adminId + "/" + product.getId(),
					String.class);
		} catch (Exception e) {
			throw new ProductNotFoundException(product.getId());
		}

		try {
			HttpEntity<Product> request = new HttpEntity<>(product);
			restTemplate.put("http://zuul-api/product/admin/products/update", request, String.class);
		} catch (Exception e) {

			response = new ResponseEntity<>("item modification failed", HttpStatus.NOT_MODIFIED);
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	@DeleteMapping("/product/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> deleteProductById(Principal principal, @PathVariable long id) {
		LOGGER.info("Start");
		String adminId = principal.getName();

		Product product = null;
		try {
			product = restTemplate.getForObject("http://zuul-api/product/admin/products/get/" + adminId + "/" + id,
					Product.class);
		} catch (Exception e) {
			throw new ProductNotFoundException();
		}
		
		ResponseEntity<String> response = new ResponseEntity<>("item deleted", HttpStatus.OK);
		try {
			if (!product.getAdminId().equals(adminId)) {
				throw new UserMisMatch(adminId, product.getAdminId());
			}
			restTemplate.delete("http://zuul-api/product/admin/products/delete/" + id, String.class);
		} catch (Exception e) {

			response = new ResponseEntity<>("item deletion failed", HttpStatus.EXPECTATION_FAILED);
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;

	}

	////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/order/get-all-by-status/{status}")
	public ResponseEntity<String> getAllOrderByAdminIdandStatus(Principal principal, @PathVariable String status) {
		String adminId1 = principal.getName();

		ResponseEntity<String> response = null;

		response = new ResponseEntity<>("no content to show", HttpStatus.NO_CONTENT);

		try {
			response = restTemplate.getForEntity(
					"http://zuul-api/order/admin/order/get-all-by-status/" + adminId1 + "/" + status, String.class);
		} catch (Exception e) {
			response = new ResponseEntity<>("no content to show", HttpStatus.NO_CONTENT);
		}

		return response;
	}

	@PutMapping("/order/update/{id}/{status}")
	public ResponseEntity<String> updateOrderStatusByAdminIdandId(Principal principal, @PathVariable long id,
			@PathVariable String status) {
		ResponseEntity<String> response = null;
		String adminId1 = principal.getName();
		response = new ResponseEntity<>("updation failed", HttpStatus.NOT_MODIFIED);
		try {
			restTemplate.put("http://zuul-api/order/admin/order/update/" + adminId1 + "/" + id + "/" + status,
					String.class);
			response = new ResponseEntity<>("item updated", HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<>("updation failed", HttpStatus.NOT_MODIFIED);
		}

		return response;

	}

}
