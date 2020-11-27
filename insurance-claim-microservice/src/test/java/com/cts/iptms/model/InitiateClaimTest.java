package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InitiateClaimTest {
	
	InitiateClaim initiateclaim=new InitiateClaim();

	@Test
	void testSetId() {
		initiateclaim.setId(101);
		assertEquals(101,initiateclaim.getId());
	}

	@Test
	void testSetSpecialist() {
		initiateclaim.setSpecialist("Urology");
		assertEquals("Urology",initiateclaim.getSpecialist());
	}

	@Test
	void testSetTreatmentCommencementDate() {
		initiateclaim.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020",initiateclaim.getTreatmentCommencementDate());
	}

	@Test
	void testSetTreatmentEndDate() {
		initiateclaim.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020",initiateclaim.getTreatmentEndDate());
	}

	@Test
	void testSetPatientName() {
		initiateclaim.setPatientName("Harry");
		assertEquals("Harry",initiateclaim.getPatientName());
	}

	@Test
	void testSetPatientStatus() {
		initiateclaim.setPatientStatus("In progress");
		assertEquals("In progress",initiateclaim.getPatientStatus());
	}

	@Test
	void testSetAilment() {
		initiateclaim.setAilment("Urology");
		assertEquals("Urology",initiateclaim.getAilment());
	}

	@Test
	void testSetTreatmentPackageName() {
		initiateclaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5",initiateclaim.getTreatmentPackageName());
	}

	@Test
	void testSetTestDetail() {
		initiateclaim.setTestDetail("Test 1");
		assertEquals("Test 1",initiateclaim.getTestDetail());
				
	}

	@Test
	void testSetInsurerName() {
		initiateclaim.setInsurerName("XYZ");
		assertEquals("XYZ",initiateclaim.getInsurerName());
	}

	@Test
	void testSetInsurerPackageName() {
		initiateclaim.setInsurerPackageName("Package 1");
		assertEquals("Package 1",initiateclaim.getInsurerPackageName());
	}

	@Test
	void testSetInsuranceAmountLimit() {
		initiateclaim.setInsuranceAmountLimit(123456);
		assertEquals(123456,initiateclaim.getInsuranceAmountLimit());
	}

	@Test
	void testSetDisbursementDuration() {
		initiateclaim.setDisbursementDuration(2);
		assertEquals(2,initiateclaim.getDisbursementDuration());
	}

	@Test
	void testSetTreatmentEndDateCost() {
		initiateclaim.setTreatmentEndDateCost(120);
		assertEquals(120,initiateclaim.getTreatmentEndDateCost());
	}

	@Test
	void testSetTreatmentDurationinWeeks() {
		initiateclaim.setTreatmentDurationinWeeks(8);
		assertEquals(8,initiateclaim.getTreatmentDurationinWeeks());
	}

	@Test
	void testSetAge() {
		initiateclaim.setAge(24);
		assertEquals(24,initiateclaim.getAge());
	}

	@Test
	void testSetFinalCost() {
		initiateclaim.setFinalCost(12500);
		assertEquals(12500,initiateclaim.getFinalCost());
	}

	@Test
	void testGetId() {
		initiateclaim.setId(101);
		assertEquals(101,initiateclaim.getId());
	}

	@Test
	void testGetSpecialist() {
		initiateclaim.setSpecialist("Urology");
		assertEquals("Urology",initiateclaim.getSpecialist());
	}

	@Test
	void testGetTreatmentCommencementDate() {
		initiateclaim.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020",initiateclaim.getTreatmentCommencementDate());
	}

	@Test
	void testGetTreatmentEndDate() {
		initiateclaim.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020",initiateclaim.getTreatmentEndDate());
	}

	@Test
	void testGetPatientName() {
		initiateclaim.setPatientName("Harry");
		assertEquals("Harry",initiateclaim.getPatientName());
	}

	@Test
	void testGetPatientStatus() {
		initiateclaim.setPatientStatus("In progress");
		assertEquals("In progress",initiateclaim.getPatientStatus());
	}

	@Test
	void testGetAilment() {
		initiateclaim.setAilment("Urology");
		assertEquals("Urology",initiateclaim.getAilment());
	}

	@Test
	void testGetTreatmentPackageName() {
		initiateclaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5",initiateclaim.getTreatmentPackageName());
	}

	@Test
	void testGetTestDetail() {
		initiateclaim.setTestDetail("Test 1");
		assertEquals("Test 1",initiateclaim.getTestDetail());
	}

	@Test
	void testGetInsurerName() {
		initiateclaim.setInsurerName("XYZ");
		assertEquals("XYZ",initiateclaim.getInsurerName());
	}

	@Test
	void testGetInsurerPackageName() {
		initiateclaim.setInsurerPackageName("Package 1");
		assertEquals("Package 1",initiateclaim.getInsurerPackageName());
	}

	@Test
	void testGetInsuranceAmountLimit() {
		initiateclaim.setInsuranceAmountLimit(123456);
		assertEquals(123456,initiateclaim.getInsuranceAmountLimit());
	}

	@Test
	void testGetDisbursementDuration() {
		initiateclaim.setDisbursementDuration(2);
		assertEquals(2,initiateclaim.getDisbursementDuration());
	}

	@Test
	void testGetTreatmentEndDateCost() {
		initiateclaim.setTreatmentEndDateCost(120);
		assertEquals(120,initiateclaim.getTreatmentEndDateCost());
	}

	@Test
	void testGetTreatmentDurationinWeeks() {
		initiateclaim.setTreatmentDurationinWeeks(8);
		assertEquals(8,initiateclaim.getTreatmentDurationinWeeks());
	}

	@Test
	void testGetAge() {
		initiateclaim.setAge(24);
		assertEquals(24,initiateclaim.getAge());
	}

	@Test
	void testGetFinalCost() {
		initiateclaim.setFinalCost(12500);
		assertEquals(12500,initiateclaim.getFinalCost());
		
	}

	

}
