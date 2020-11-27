package com.cts.iptms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RestController;


import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;

import com.cts.iptms.service.InsuranceClaimServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InsuranceClaimController {



	@Autowired
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceClaimController.class);
	
	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@GetMapping(value = "/GetAllInsurerDetail")
	public List<InsurerDetail> getAllInsurerDetail(@RequestHeader("Authorization") String token) {
		LOGGER.debug("start");
		
		
		insuranceClaimServiceImpl.validateToken(token);
		List<InsurerDetail> insurerDetailList = insuranceClaimServiceImpl.getAllInsurerDetail();
		LOGGER.debug("end");
		return insurerDetailList;
	}

	@GetMapping(value = "/GetInsurerByPackageName/{packageId}")
	public InsurerDetail getInsurerDetail(@RequestHeader("Authorization") String token, @PathVariable long packageId) {
		LOGGER.debug("start");
		insuranceClaimServiceImpl.validateToken(token);
		InsurerDetail insurerDetail = insuranceClaimServiceImpl.getInsurerDetail(packageId);
		LOGGER.debug("end");
		return insurerDetail;
	}

	@GetMapping(value = "/GetInsuredPatient/{patientId}")
	public InitiateClaim getInsurerdPatient(@RequestHeader("Authorization") String token,
			@PathVariable long patientId) {
		LOGGER.debug("start");
		insuranceClaimServiceImpl.validateToken(token);
		InitiateClaim initiateClaim=insuranceClaimServiceImpl.getPatientFinalInfo(patientId);
		LOGGER.debug("end");
		return initiateClaim;
	}

	@PostMapping(value = "/InitiateClaim")
	public int initiateClaim(@RequestHeader("Authorization") String token, @RequestBody InitiateClaim initiateClaim) {
		LOGGER.debug("start");
		insuranceClaimServiceImpl.validateToken(token);
		int cost = insuranceClaimServiceImpl.initiateClaim(initiateClaim);
		LOGGER.debug("end");
		return cost;
	}

}
