package com.cts.iptms.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IPTreatmentPackageTest {
	
	IPTreatmentPackage iptreatment=new IPTreatmentPackage();
	PackageDetail packagedetail=new PackageDetail(); 

	@Test
	void testIPTreatmentPackageLongStringPackageDetail() {
		PackageDetail detail=new PackageDetail();
		IPTreatmentPackage treatment=new IPTreatmentPackage(101,"Urology",detail);
		
		assertEquals(treatment.getId(),101);
	}

	
	
	@Test
	void testSetId() {
		iptreatment.setId(10);
		assertEquals(iptreatment.getId(),10);
	}

	@Test
	void testGetId() {
		iptreatment.setId(10);
		assertEquals(10,iptreatment.getId());
		
	}

	@Test
	void testSetAilmentCategory() {
		iptreatment.setAilmentCategory("Urology");
		assertEquals(iptreatment.getAilmentCategory(),"Urology");
	}

	@Test
	void testGetAilmentCategory() {
		iptreatment.setAilmentCategory("Urology");
		assertEquals("Urology",iptreatment.getAilmentCategory());
	}

	@Test
	void testSetPackageDetail() {
		PackageDetail detail=new PackageDetail();
		iptreatment.setPackageDetail(detail);
		assertEquals(iptreatment.getPackageDetail(),detail);
	}
	
	@Test
	void testGetPackageDetail() {
		PackageDetail detail=new PackageDetail();
		iptreatment.setPackageDetail(detail);;
		assertEquals(detail,iptreatment.getPackageDetail());
	}

	

	
	

}
