package com.cts.iptms.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;

@FeignClient(url = "${ipt.mgmt}", name = "ipt-microservice")
public interface IPTFClient {
	
	@RequestMapping(value = "/FormulateTreatmentTimetable/{cost}", method = RequestMethod.POST)
	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader("Authorization") String token,@RequestBody PatientDetail patientDetail,@PathVariable int cost);
	//
	
	@GetMapping("/getPatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId, @RequestHeader("Authorization") String token );
	
	@GetMapping("/getAllPlans")
	public List<TreatmentPlan> getAllPatients( @RequestHeader("Authorization") String token );
	
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable long ptId, @RequestHeader("Authorization") String token );
	
	@PutMapping("/updatePlan/{pId}")
	public void updatePlan(@RequestHeader("Authorization") String token, @PathVariable long pId);
}
