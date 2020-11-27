package com.cts.iptms.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.meta.When;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.service.IPtreatmentofferingsService;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class IPtreatmentofferingsControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	IPtreatmentofferingsService iptreatmentofferingsService;

	@Test
	void testGetIPTreatmentPackages() throws Exception {
		when(iptreatmentofferingsService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));

		mockMvc.perform(get("/IPTreatmentPackages").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptreatmentofferingsService, times(1)).validateToken("token");
		verify(iptreatmentofferingsService,times(1)).getIPTreatmentPackages();

	}

	@Test
	void testGetIPTreatmentPackageByAilmentCategoryAndName() throws Exception {
		when(iptreatmentofferingsService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));

		mockMvc.perform(get("/IPTreatmentPackageByName/c1/package1").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptreatmentofferingsService, times(1)).validateToken("token");
		verify(iptreatmentofferingsService,times(1)).getIPTreatmentPackageByAilmentCategoryAndName("package1","c1");
	}

	@Test
	void testGetSpecialists() throws Exception {
		when(iptreatmentofferingsService.validateToken("token")).thenReturn(new AuthResponse("sud", "name", true));

		mockMvc.perform(get("/specialists").header("Authorization", "token")).andExpect(status().isOk());
		verify(iptreatmentofferingsService, times(1)).validateToken("token");
		verify(iptreatmentofferingsService,times(1)).getSpecialists();
	}

}
