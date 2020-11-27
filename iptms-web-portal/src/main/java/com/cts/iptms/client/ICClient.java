package com.cts.iptms.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;

@FeignClient(url = "${ins.claim}", name = "insurance-micro")
public interface ICClient {
	
	@RequestMapping(value = "/GetAllInsurerDetail", method = RequestMethod.GET)
	public List<InsurerDetail> getAllInsurerDetail(@RequestHeader("Authorization") String token);
	
	@RequestMapping(value = "/GetInsurerByPackageName/{packageId}", method = RequestMethod.GET)
	public InsurerDetail getInsurerDetail(@RequestHeader("Authorization") String token,@PathVariable long packageId);
	
	@RequestMapping(value = "/GetInsuredPatient/{patientId}", method = RequestMethod.GET)
	public InitiateClaim getInsurerdPatient(@RequestHeader("Authorization") String token,@PathVariable long patientId);

	@RequestMapping(value = "/InitiateClaim", method = RequestMethod.POST)
	public int initiateClaim(@RequestHeader("Authorization") String token,@RequestBody InitiateClaim initiateClaim);
}
