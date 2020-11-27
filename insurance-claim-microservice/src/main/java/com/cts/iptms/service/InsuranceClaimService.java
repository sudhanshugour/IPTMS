package com.cts.iptms.service;

import java.util.List;

import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;

public interface InsuranceClaimService {
	
	public List<InsurerDetail> getAllInsurerDetail();
	
	
	
	public InsurerDetail getInsurerDetail(long packageId);
	
	
	public AuthResponse validateToken(String token);
	public InitiateClaim getPatientFinalInfo(long id);
	public int initiateClaim(InitiateClaim initiateClaim);
}
