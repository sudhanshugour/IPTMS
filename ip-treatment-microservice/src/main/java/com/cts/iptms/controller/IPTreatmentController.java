package com.cts.iptms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.service.IPTreatmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IPTreatmentController {
	
	
	@Autowired
	AuthClient authClient;
	
	@Autowired
	IPTreatmentServiceImpl iptService;
	
	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/FormulateTreatmentTimetable/{cost}")
	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader("Authorization") String token,
			@RequestBody PatientDetail patientDetail,@PathVariable int cost) {
		iptService.validateToken(token);
		
		return iptService.getTreatmentPlan(patientDetail, cost);
		
	}
	
	@GetMapping("/getAllPlans")
	public List<TreatmentPlan> getAllPatients( @RequestHeader("Authorization") String token ){
		iptService.validateToken(token);
		return iptService.getAllPlans();
	}
	
	@GetMapping("/getPatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId, @RequestHeader("Authorization") String token ){
		iptService.validateToken(token);
		return iptService.getPatient(ptId);
	}
	
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable int ptId, @RequestHeader("Authorization") String token ){
		iptService.validateToken(token);
		return iptService.getPlan(ptId);
	}
	
	@PutMapping("/updatePlan/{pId}")
	public void updatePlan(@RequestHeader("Authorization") String token,@PathVariable long pId) {
		iptService.validateToken(token);
		iptService.updatePlan(pId);
	}
	
	
	
	
}
