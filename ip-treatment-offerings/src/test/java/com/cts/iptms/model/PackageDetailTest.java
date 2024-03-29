package com.cts.iptms.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PackageDetailTest {
	
	PackageDetail packagedetail=new PackageDetail();


	@Test
	void testPackageDetailStringStringIntInt() {
		PackageDetail detail=new PackageDetail("Package 1","Urology",1000,4);
		assertEquals(1000,detail.getCost());
	}

	@Test
	void testPackageDetail() {
		PackageDetail detail=new PackageDetail();
		detail.setTestDetail("Urology");
		assertEquals("Urology",detail.getTestDetail());
	}

	@Test
	void testTreatmentPackageName()
	{
		packagedetail.setTreatmentPackageName("Package 3");
		assertEquals("Package 3",packagedetail.getTreatmentPackageName());
	}
	
	@Test
	void testTestDetails()
	{
		packagedetail.setTestDetail("OPT1,0PT3");
		assertEquals("OPT1,0PT3",packagedetail.getTestDetail());
	}
	
	@Test
	void testCost()
	{
		packagedetail.setCost(5000);
		assertEquals(5000,packagedetail.getCost());
	}
	
	@Test
	void testTreatmentDuration()
	{
		packagedetail.setTreatmentDurationinWeeks(4);
		assertEquals(4,packagedetail.getTreatmentDurationinWeeks());
	}
	
	@Test
	void testtoString() 
	{
        String s = packagedetail.toString();
        assertEquals(s,packagedetail.toString());
    }
	

}
