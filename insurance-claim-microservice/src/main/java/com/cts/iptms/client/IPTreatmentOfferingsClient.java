//package com.cts.iptms.client;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.cts.iptms.model.IPTreatmentPackage;
//import com.cts.iptms.model.SpecialistDetail;
//
//@FeignClient(url = "${fos.iptoffering}", name = "iptms-offering")
//public interface  IPTreatmentOfferingsClient {
//
//	@RequestMapping(value = "/IPTreatmentPackages", method = RequestMethod.GET)
//	public List<IPTreatmentPackage> getIPTreatmentPackages(@RequestHeader("Authorization") String token);
//	
//	@RequestMapping(value = "/IPTreatmentPackageByName/{AilmentCategory}/{packageName}", method = RequestMethod.GET)
//	public IPTreatmentPackage getIPTreatmentPackageByAilmentCategoryAndName(@RequestHeader("Authorization") String token,@PathVariable String AilmentCategory,@PathVariable String packageName);
//	
//	
//	@RequestMapping(value = "/specialists", method = RequestMethod.GET)
//	public List<SpecialistDetail> getSpecialists(@RequestHeader("Authorization") String token);
//	
//	
//}
