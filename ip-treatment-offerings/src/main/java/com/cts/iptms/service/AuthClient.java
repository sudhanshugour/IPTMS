package com.cts.iptms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


import com.cts.iptms.model.AuthResponse;

import com.cts.iptms.model.UserHospital;



@FeignClient(url = "${fos.auth}", name = "iptms-auth")
public interface AuthClient {
	
	

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserHospital userlogincredentials);

	
	@GetMapping(value = "/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token) ;


}
