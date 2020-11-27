package com.cts.iptms.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreatmentPlanTest {

 
	TreatmentPlan treatmentplan=new TreatmentPlan();
	
	@Test
	void testSetId() {
		treatmentplan.setId(10);
		assertEquals(treatmentplan.getId(),10);
	}
	
	@Test
	void testGetId() {
		treatmentplan.setId(10);
		assertEquals(10,treatmentplan.getId());
	}
	
	
	
	@Test
	void testSetTestDetails() {
		treatmentplan.setTestDetails("Urology");
		assertEquals(treatmentplan.getTestDetails(),"Urology");
	}

	@Test
	void testGetTestDetails() {
		treatmentplan.setTestDetails("Urology");
		assertEquals("Urology",treatmentplan.getTestDetails());
	}


	@Test
	void testSetPackageName() {
		treatmentplan.setPackageName("Package 1");
		assertEquals(treatmentplan.getPackageName(),"Package 1");
	}
	
	
	
	@Test
	void testGetPackageName() {
		treatmentplan.setPackageName("Package 1");
		assertEquals("Package 1",treatmentplan.getPackageName());
	}
	
	@Test
	void testSetSpecialist() {
		treatmentplan.setSpecialist("Orthopeadics");
		assertEquals(treatmentplan.getSpecialist(),"Orthopeadics");
	}

	@Test
	void testGetSpecialist() {
		treatmentplan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics",treatmentplan.getSpecialist());
	}
	
	
	
	@Test
	void testSetStatus() {
		treatmentplan.setStatus("In progress");
		assertEquals(treatmentplan.getStatus(),"In progress");
	}

	@Test
	void testGetStatus() {
		treatmentplan.setStatus("In progress");
		assertEquals("In progress",treatmentplan.getStatus());
	}
	
	@Test
	void testSetTreatmentCommencementDate() {
		treatmentplan.setTreatmentCommencementDate("10/11/2020");
		assertEquals(treatmentplan.getTreatmentCommencementDate(),"10/11/2020");
	}

	@Test
	void testGetTreatmentCommencementDate() {
		treatmentplan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020",treatmentplan.getTreatmentCommencementDate());
	}

	@Test
	void testSetTreatmentEndDate() {
		treatmentplan.setTreatmentEndDate("10/12/2020");
		assertEquals(treatmentplan.getTreatmentEndDate(),"10/12/2020");
	}
	
	@Test
	void testGetTreatmentEndDate() {
		treatmentplan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020",treatmentplan.getTreatmentEndDate());
	}

	
}
