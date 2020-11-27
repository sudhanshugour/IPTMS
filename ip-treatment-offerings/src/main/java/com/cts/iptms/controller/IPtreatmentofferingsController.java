package com.cts.iptms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.iptms.model.IPTreatmentPackage;

import com.cts.iptms.model.SpecialistDetail;

import com.cts.iptms.service.IPtreatmentofferingsService;

import lombok.extern.slf4j.Slf4j;




@Controller
@Slf4j
public class IPtreatmentofferingsController {

	
	@Autowired
	IPtreatmentofferingsService iptreatmentofferingsService;
	
	@GetMapping(path = "/IPTreatmentPackages")
	public ResponseEntity<List<IPTreatmentPackage>> getIPTreatmentPackages(@RequestHeader(name = "Authorization") String token) {
		log.debug("Start : {}", "getIPTreatmentPackages");
		iptreatmentofferingsService.validateToken(token);
		log.debug("END : {}", "getIPTreatmentPackages");

		return new ResponseEntity<>(iptreatmentofferingsService.getIPTreatmentPackages(), HttpStatus.OK);
	}

	@GetMapping(path = "/IPTreatmentPackageByName/{category}/{packageName}")
	public ResponseEntity<IPTreatmentPackage> getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,@PathVariable String packageName, @RequestHeader(name = "Authorization") String token) {
		log.debug("Start : {}", "getIPTreatmentPackageByAilmentCategoryAndName");
		iptreatmentofferingsService.validateToken(token);
		log.debug("End : {}", "getIPTreatmentPackageByAilmentCategoryAndName");

		return new ResponseEntity<>(iptreatmentofferingsService.getIPTreatmentPackageByAilmentCategoryAndName(packageName,category), HttpStatus.OK);
	}
	
	@GetMapping(value = "/specialists")
	public  ResponseEntity<List<SpecialistDetail>> getSpecialists(@RequestHeader("Authorization") String token){
		log.debug("Start : {}", "getSpecialists");

		iptreatmentofferingsService.validateToken(token);
		
		log.debug("End : {}", "getSpecialists");
		return new ResponseEntity<>(iptreatmentofferingsService.getSpecialists(), HttpStatus.OK);
	}
}
