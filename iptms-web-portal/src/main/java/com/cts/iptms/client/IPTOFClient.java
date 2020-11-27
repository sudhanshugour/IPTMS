package com.cts.iptms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${ipt.offering}", name = "ipt-off-microservice")
public interface IPTOFClient {
	@RequestMapping(path = "/IPTreatmentPackages", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackages(@RequestHeader(name = "Authorization") String token);

	@RequestMapping(path = "/IPTreatmentPackageByName/{category}/{packageName}", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,@PathVariable String packageName, @RequestHeader(name = "Authorization") String token);
}
