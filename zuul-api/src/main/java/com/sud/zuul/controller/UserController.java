package com.sud.zuul.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sud.zuul.exception.ProductNotFoundException;
import com.sud.zuul.exception.UserMisMatch;
import com.sud.zuul.model.Order;
import com.sud.zuul.model.Product;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/product/get-by-adminId/{adminId}")
	public ResponseEntity<String> getProductsByAdminIdAndStatus(@PathVariable String adminId) {
		LOGGER.info("Start");
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.getForEntity("http://zuul-api/product/user/products/get-by-adminId/" + adminId,
					String.class);
		} catch (Exception e) {
			throw new ProductNotFoundException();
		}
		LOGGER.info("response{}:", response);
		LOGGER.info("End");
		return response;

	}

	///////////////////////////////////////////////////////////////////////////

	@PostMapping("/order/add")
	public ResponseEntity<String> addOrder(Principal principal, @Valid @RequestBody Order order) {
		String userId1 = principal.getName();

		
		if (!userId1.equals(order.getUserId())) {
			throw new UserMisMatch(userId1, order.getUserId());
		}
		
		
		ResponseEntity<String> response = null;
		HttpEntity<Order> request = new HttpEntity<>(order);
		response = new ResponseEntity<>("item not added", HttpStatus.EXPECTATION_FAILED);

		try {
			
			response = restTemplate.postForEntity(
					"http://zuul-api/order/user/order/add" ,request, String.class);
		} catch (Exception e) {
			response = new ResponseEntity<>("item not added", HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}

	@PutMapping("/order/update")
	public ResponseEntity<String> updateOrder(Principal principal, @Valid @RequestBody Order order) {
		String userId1 = principal.getName();
		if (!userId1.equals(order.getUserId())) {
			throw new UserMisMatch(userId1, order.getUserId());
		}
		ResponseEntity<String> response = null;
		HttpEntity<Order> request = new HttpEntity<>(order);
		response = new ResponseEntity<>("item not updated", HttpStatus.EXPECTATION_FAILED);

		try {
			 restTemplate.put("http://zuul-api/order/user/order/update",request , String.class);
			response = new ResponseEntity<>("item  updated", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>("item not updated", HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}

	@DeleteMapping("/order/delete/{id}")
	public ResponseEntity<String> deleteOrderByIdandUserId(Principal principal, @PathVariable long id) {
		String userId = principal.getName();
		ResponseEntity<String> response = null;

		response = new ResponseEntity<>("item not deleted", HttpStatus.EXPECTATION_FAILED);

		try {
			
			restTemplate.delete(
					"http://zuul-api/order/user/order/delete/"+userId+"/"+id , String.class);
			
			response = new ResponseEntity<>("item deleted", HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<>("item not deleted", HttpStatus.EXPECTATION_FAILED);
		}

		return response;

	}

	@GetMapping("/order/get-all-by-status/{status}")
	public ResponseEntity<String> getAllOrderByUserIdandStatus(Principal principal, @PathVariable String status) {
		String userId = principal.getName();

		
		ResponseEntity<String> response = null;

		response = new ResponseEntity<>("no content to show", HttpStatus.NO_CONTENT);

		try {
			response = restTemplate.getForEntity(
					"http://zuul-api/order/user/order/get-all-by-status/"+userId+"/"+status , String.class);
		} catch (Exception e) {
			response = new ResponseEntity<>("no content to show", HttpStatus.NO_CONTENT);
		}

		return response;
	}



}
