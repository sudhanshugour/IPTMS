//package com.cts.iptms.client;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.cts.iptms.model.IPTreatmentPackage;
//import com.cts.iptms.model.PatientDetail;
//import com.cts.iptms.model.SpecialistDetail;
//import com.cts.iptms.model.TreatmentPlan;
//
//@FeignClient(url = "${fos.ipt}", name = "iptms-treatment")
//public interface  IPTreatmentClient {
//
//	@RequestMapping(value = "/FormulateTreatmentTimetable", method = RequestMethod.GET)
//	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader("Authorization") String token,@RequestBody PatientDetail patientDetail);
//	
//	
//	
//	
//}
