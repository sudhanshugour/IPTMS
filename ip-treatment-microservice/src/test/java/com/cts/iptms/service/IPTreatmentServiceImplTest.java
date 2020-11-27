package com.cts.iptms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.exception.InvalidTokenException;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.repository.PatientDetailRepository;
import com.cts.iptms.repository.TreatmentPlanRepository;

@ExtendWith(MockitoExtension.class)
class IPTreatmentServiceImplTest {

	@Mock
	PatientDetailRepository patientdetailRepository;

	@Mock
	AuthClient authClient;

	@Mock
	TreatmentPlanRepository tPRepo;
	@InjectMocks
	IPTreatmentServiceImpl iPTreatmentServiceImpl;
	@Test
	void testValidateToken() {
		when( authClient.getValidity("token")).thenReturn(new AuthResponse("sud", "name", true));
		assertEquals( "name",iPTreatmentServiceImpl.validateToken("token").getName());
		
		
	}

	@Test
	void testValidateTokenWithInvalidToken() {
		when( authClient.getValidity("token")).thenReturn(new AuthResponse("sud", "name", false));

		assertThrows( InvalidTokenException.class, ()->iPTreatmentServiceImpl.validateToken("token"));
	}
	@Test
	void testValidateTokenThrowsException() {
		when( authClient.getValidity("token")).thenThrow(RuntimeException.class);
		assertThrows( InvalidTokenException.class, ()->iPTreatmentServiceImpl.validateToken("token"));
	}
	@Test
	void testGetTreatmentPlanPackage1() {
		
		PatientDetail patientDetail = new PatientDetail(10, "name", 10, "ailment", "package1", "");
		TreatmentPlan treatmentPlan = iPTreatmentServiceImpl.getTreatmentPlan(patientDetail, 2000) ;
		assertEquals("Senior Specialist", treatmentPlan.getSpecialist());
	
		verify(tPRepo,times(1)).save(treatmentPlan);
		verify(patientdetailRepository,times(1)).save(patientDetail);
	}
	@Test
	void testGetTreatmentPlanPackage2() {
		
		PatientDetail patientDetail = new PatientDetail(10, "name", 10, "ailment", "package2", "");
		TreatmentPlan treatmentPlan = iPTreatmentServiceImpl.getTreatmentPlan(patientDetail, 2000) ;
		assertEquals("Junior Specialist", treatmentPlan.getSpecialist());
	
		verify(tPRepo,times(1)).save(treatmentPlan);
		verify(patientdetailRepository,times(1)).save(patientDetail);
	}
	@Test
	void testReviewDateAndMonth() {
		assertEquals("10", iPTreatmentServiceImpl.reviewDateAndMonth(10));
		assertEquals("01", iPTreatmentServiceImpl.reviewDateAndMonth(1));
	}

	@Test
	void testGetAllPlans() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		
		when(tPRepo.getAllplans()).thenReturn(treatmentPlans);
		assertEquals(treatmentPlans, iPTreatmentServiceImpl.getAllPlans());
	}

	@Test
	void testGetPatient() {
		
		
		PatientDetail pDetails = new PatientDetail();
		pDetails.setId(10);
		when(patientdetailRepository.getPatientById(10)).thenReturn(pDetails);
		assertEquals(pDetails.getId(), iPTreatmentServiceImpl.getPatient(10).getId());
	}

	@Test
	void testGetPlan() {
		
		TreatmentPlan tp =new TreatmentPlan();
		when(tPRepo.getPlanUser(0)).thenReturn(tp);
		assertEquals(tp, iPTreatmentServiceImpl.getPlan(0));
	}

	@Test
	void testUpdatePlan() {
		TreatmentPlan tp =new TreatmentPlan();
		when(tPRepo.getPlanUser(0)).thenReturn(tp);
		iPTreatmentServiceImpl.updatePlan(0);
		
		verify(tPRepo,times(1)).save(tp);
		verify(tPRepo,times(1)).getPlanUser(0);
	}

}
