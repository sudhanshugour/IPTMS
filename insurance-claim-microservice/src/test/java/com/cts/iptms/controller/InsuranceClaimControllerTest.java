package com.cts.iptms.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.exception.InsurerDetailNotFoundException;
import com.cts.iptms.exception.InvalidTokenException;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;
import com.cts.iptms.service.InsuranceClaimServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class InsuranceClaimControllerTest {

	@MockBean
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;

	@Autowired
	MockMvc mockMvc;

	@Test
	void testGetAllInsurerDetail200() throws Exception {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(0l, "insurerName", "insurerPackageName", 200, 8));
		when(insuranceClaimServiceImpl.getAllInsurerDetail()).thenReturn(insurerDetailList);
		when(insuranceClaimServiceImpl.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));

		mockMvc.perform(get("/GetAllInsurerDetail").header("Authorization", "token")).andExpect(status().isOk());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");

	}

	@Test
	void testGetAllInsurerDetail403() throws Exception {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(0l, "insurerName", "insurerPackageName", 200, 8));
		when(insuranceClaimServiceImpl.getAllInsurerDetail()).thenReturn(insurerDetailList);
		when(insuranceClaimServiceImpl.validateToken("token")).thenThrow(InvalidTokenException.class);

		mockMvc.perform(get("/GetAllInsurerDetail").header("Authorization", "token")).andExpect(status().isForbidden());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");

	}

	@Test
	void testGetInsurerDetail200() throws Exception {
		when(insuranceClaimServiceImpl.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		when(insuranceClaimServiceImpl.getInsurerDetail(1l)).thenReturn(new InsurerDetail(0l, "insurerName", "insurerPackageName", 200, 8));
		mockMvc.perform(get("/GetInsurerByPackageName/1").header("Authorization", "token")).andExpect(status().isOk());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");
	}
	
	
	@Test
	void testGetInsurerDetail403() throws Exception {
		when(insuranceClaimServiceImpl.validateToken("token")).thenThrow(InvalidTokenException.class);
		when(insuranceClaimServiceImpl.getInsurerDetail(1l)).thenReturn(new InsurerDetail(0l, "insurerName", "insurerPackageName", 200, 8));
		mockMvc.perform(get("/GetInsurerByPackageName/1").header("Authorization", "token")).andExpect(status().isForbidden());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");
	}

	@Test
	void testInitiateClaim403() throws Exception {
		when(insuranceClaimServiceImpl.validateToken("token")).thenThrow(InvalidTokenException.class);
		
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 100, 6, 200, 5, 22, 0);		

		when(insuranceClaimServiceImpl.initiateClaim(initiateClaim)).thenReturn(100);

		mockMvc.perform(

				MockMvcRequestBuilders.post("/InitiateClaim").content(asJsonString(initiateClaim))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
		).andExpect(status().isForbidden());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");
	}
	
	@Test
	void testInitiateClaim200() throws Exception {
		when(insuranceClaimServiceImpl.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 100, 6, 200, 5, 22, 0);		

		when(insuranceClaimServiceImpl.initiateClaim(initiateClaim)).thenReturn(100);

		mockMvc.perform(

				MockMvcRequestBuilders.post("/InitiateClaim").content(asJsonString(initiateClaim))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
		).andExpect(status().isOk());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");
	}
	

	
	@Test
	void testGetInsurerdPatient200() throws Exception {
		when(insuranceClaimServiceImpl.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 100, 6, 200, 5, 22, 0);		

		when(insuranceClaimServiceImpl.getPatientFinalInfo(1l)).thenReturn(initiateClaim);
		mockMvc.perform(get("/GetInsuredPatient/1").header("Authorization", "token")).andExpect(status().isOk());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");
	}

	@Test
	void testGetInsurerdPatient403() throws Exception {
		when(insuranceClaimServiceImpl.validateToken("token")).thenThrow(InvalidTokenException.class);
		InitiateClaim initiateClaim = new InitiateClaim(0, "Specialist", "treatmentCommencementDate", "treatmentEndDate", "patientName", "patientStatus", "ailment", "treatmentPackageName", "testDetail", "insurerName", "insurerPackageName", 100, 6, 200, 5, 22, 0);		

		when(insuranceClaimServiceImpl.getPatientFinalInfo(1l)).thenReturn(initiateClaim);
		mockMvc.perform(get("/GetInsuredPatient/1").header("Authorization", "token")).andExpect(status().isForbidden());
		verify(insuranceClaimServiceImpl, times(1)).validateToken("token");
	}

	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
