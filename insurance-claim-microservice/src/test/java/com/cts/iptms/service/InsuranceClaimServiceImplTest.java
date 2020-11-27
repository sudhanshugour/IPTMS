package com.cts.iptms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.exception.InsurerDetailNotFoundException;
import com.cts.iptms.exception.InvalidTokenException;
import com.cts.iptms.exception.PatientDetailNotFoundException;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;
import com.cts.iptms.repository.InitiateClaimRepository;
import com.cts.iptms.repository.InsurerDetailRepository;


@ExtendWith(MockitoExtension.class)
class InsuranceClaimServiceImplTest {

	
	
	
	@Mock
	InsurerDetailRepository insurerDetailRepository;
	@Mock
	InitiateClaimRepository initiateClaimRepository;
	@InjectMocks
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;
	
	@Mock
	AuthClient authClient;
	
	
	
	@Test
	void testGetAllInsurerDetail() {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(0l, "insurerName", "insurerPackageName", 200, 8));
		when(insurerDetailRepository.findAll()).thenReturn(insurerDetailList);
		
		assertEquals( "insurerPackageName",insuranceClaimServiceImpl.getAllInsurerDetail().get(0).getInsurerPackageName());
		
	}
	@Test
	void testGetAllInsurerDetailFailed() {
		
		when(insurerDetailRepository.findAll()).thenThrow(new RuntimeException());
		
		assertThrows(InsurerDetailNotFoundException.class, ()->insuranceClaimServiceImpl.getAllInsurerDetail());
	}

	
	
	@Test
	void testGetInsurerDetail() {
		
		Optional<InsurerDetail> insOptional = Optional.of(new InsurerDetail(0l, "insurerName", "insurerPackageName", 200, 8));
		when(insurerDetailRepository.findById(1l)).thenReturn(insOptional);
		assertEquals( "insurerPackageName",insuranceClaimServiceImpl.getInsurerDetail(1l).getInsurerPackageName());
	}

	@Test
	void testGetInsurerDetailFailed() {
		
		Optional<InsurerDetail> insOptional = Optional.empty();
		when(insurerDetailRepository.findById(1l)).thenReturn(insOptional);
		assertThrows(InsurerDetailNotFoundException.class, ()->insuranceClaimServiceImpl.getInsurerDetail(1l));	}

	
	
	@Test
	void testInitiateClaim() {
		
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 100, 6, 200, 5, 22, 0);		
				assertEquals(100, insuranceClaimServiceImpl.initiateClaim(initiateClaim));
	}
	
	
	
	@Test
	void testInitiateClaimWhenInsuranceAmountIsGreaterThanPackageAmount() {
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 1000, 6, 200, 5, 22, 0);		
		assertEquals(0, insuranceClaimServiceImpl.initiateClaim(initiateClaim));
	}
	

	@Test
	void testValidateToken() {
		when( authClient.getValidity("token")).thenReturn(new AuthResponse("sud", "name", true));
		assertEquals( "name",insuranceClaimServiceImpl.validateToken("token").getName());
		
		
	}
	
	@Test
	void testValidateTokenWithInvalidToken() {
		when( authClient.getValidity("token")).thenReturn(new AuthResponse("sud", "name", false));

		assertThrows( InvalidTokenException.class, ()->insuranceClaimServiceImpl.validateToken("token"));
	}
	@Test
	void testValidateTokenThrowsException() {
		when( authClient.getValidity("token")).thenThrow(RuntimeException.class);
		assertThrows( InvalidTokenException.class, ()->insuranceClaimServiceImpl.validateToken("token"));
	}
	
	@Test
	void testGetPatientFinalInfo() {
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 1000, 6, 200, 5, 22, 0);		

		Optional<InitiateClaim> iniOptional = Optional.of(initiateClaim);
		when(initiateClaimRepository.findById(0l)).thenReturn(iniOptional);
		assertEquals(0l,insuranceClaimServiceImpl.getPatientFinalInfo(0l).getId());
	}
	

	@Test
	void testGetPatientFinalInfoFailed() {

		Optional<InitiateClaim> iniOptional = Optional.empty();
		when(initiateClaimRepository.findById(0l)).thenReturn(iniOptional);
		assertThrows(PatientDetailNotFoundException.class, ()->insuranceClaimServiceImpl.getPatientFinalInfo(0l));	
		}
	

}
