package com.cts.iptms.controller;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.service.IPTreatmentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class IPTreatmentControllerTest {

	@MockBean
	AuthClient authClient;
	@Autowired
	MockMvc mockMvc;

	@MockBean
	IPTreatmentServiceImpl iptService;

	@Test
	void testGetAllPatients200() throws Exception {
		when(iptService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();

		when(iptService.getAllPlans()).thenReturn(treatmentPlans);
		mockMvc.perform(get("/getAllPlans").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptService, timeout(1)).getAllPlans();
		verify(iptService, timeout(1)).validateToken("token");

	}

	@Test
	void testGetPatient() throws Exception {
		when(iptService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		PatientDetail patientDetail = new PatientDetail();
		when(iptService.getPatient(2)).thenReturn(patientDetail);
		mockMvc.perform(get("/getPatient/2").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptService, timeout(1)).getPatient(2);
		verify(iptService, timeout(1)).validateToken("token");
	}

	@Test
	void testGetAPlan() throws Exception {
		when(iptService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		TreatmentPlan treatmentPlan = new TreatmentPlan();
		when(iptService.getPlan(6)).thenReturn(treatmentPlan);
		mockMvc.perform(get("/getplan/6").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptService, timeout(1)).getPlan(6);
		verify(iptService, timeout(1)).validateToken("token");
	}

	@Test
	void testUpdatePlan() throws Exception {

		when(iptService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));

		mockMvc.perform(put("/updatePlan/7").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptService, timeout(1)).updatePlan(7);
		verify(iptService, timeout(1)).validateToken("token");
	}

	@Test
	void testFormulateTreatmentTimetable() throws Exception {
		when(iptService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));
		PatientDetail patientDetail = new PatientDetail();
		
		mockMvc.perform(

				MockMvcRequestBuilders.post("/FormulateTreatmentTimetable").content(asJsonString(patientDetail))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
						.header("Authorization", "token"))
				.andExpect(status().isOk());
		verify(iptService, timeout(1)).validateToken("token");
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
