package com.cts.iptms.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientDetailTest {
	
	PatientDetail patientdetail=new PatientDetail();

	@Test
	void testPatientDetailLongStringIntStringStringString() {
		PatientDetail patientdata=new PatientDetail(101,"Harry",24,"Urology","Package 1","10/11/2020");
		assertEquals(patientdata.getId(),101);
		
	}

	
	@Test
	void testSetId() {
		patientdetail.setId(101);
		assertEquals(patientdetail.getId(),101);
		
	}

	@Test
	void testGetId() {
		patientdetail.setId(101);
		assertEquals(101,patientdetail.getId());
	}

	
	@Test
	void testSetName() {
		patientdetail.setName("Harry");;
		assertEquals(patientdetail.getName(),"Harry");
	}
	
	
	@Test
	void testGetName() {
		
		patientdetail.setName("Harry");;
		assertEquals("Harry",patientdetail.getName());
		
	}
	
	@Test
	void testSetAge() {
		patientdetail.setAge(24);
		assertEquals(patientdetail.getAge(),24);
	}

	@Test
	void testGetAge() {
		patientdetail.setAge(24);
		
		assertEquals(24,patientdetail.getAge());
	}
	
	@Test
	void testSetAilment() {
		patientdetail.setAilment("Urology");;
		assertEquals(patientdetail.getAilment(),"Urology");
	}

	@Test
	void testGetAilment() {
		patientdetail.setAilment("Urology");;
		assertEquals("Urology",patientdetail.getAilment());
	}
	
	@Test
	void testSetTreatmentPackageName() {
		patientdetail.setTreatmentPackageName("Package 1");
		assertEquals(patientdetail.getTreatmentPackageName(),"Package 1");
	}

	@Test
	void testGetTreatmentPackageName() {
		patientdetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1",patientdetail.getTreatmentPackageName());
	}
	
	@Test
	void testSetTreatmentCommencementDate() {
		patientdetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals(patientdetail.getTreatmentCommencementDate(),"10/11/2020");
	}

	@Test
	void testGetTreatmentCommencementDate() {
		patientdetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020",patientdetail.getTreatmentCommencementDate());
	}

	

	

	

	

	

	

}
