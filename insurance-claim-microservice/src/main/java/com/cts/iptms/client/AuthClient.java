package com.cts.iptms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


import com.cts.iptms.model.AuthResponse;



@FeignClient(url = "${fos.auth}", name = "iptms-auth")
public interface AuthClient {
	
	

	
	@GetMapping(value = "/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token) ;


}
