package com.cts.iptms.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PackageDetailTest {
	
	PackageDetail packagedetail=new PackageDetail();


	@Test
	void testPackageDetailStringStringIntInt() {
		PackageDetail detail=new PackageDetail("Package 1","Urology",1000,4);
		assertEquals(detail.getCost(),1000);
	}

	@Test
	void testPackageDetail() {
		PackageDetail detail=new PackageDetail();
		detail.setTestDetail("Urology");
		assertEquals(detail.getTestDetail(),"Urology");
	}

	@Test
	public void testTreatmentPackageName()
	{
		packagedetail.setTreatmentPackageName("Package 3");
		assertEquals(packagedetail.getTreatmentPackageName(), "Package 3");
	}
	
	@Test
	public void testTestDetails()
	{
		packagedetail.setTestDetail("OPT1,0PT3");
		assertEquals(packagedetail.getTestDetail(), "OPT1,0PT3");
	}
	
	@Test
	public void testCost()
	{
		packagedetail.setCost(5000);
		assertEquals(packagedetail.getCost(), 5000);
	}
	
	@Test
	public void testTreatmentDuration()
	{
		packagedetail.setTreatmentDurationinWeeks(4);
		assertEquals(packagedetail.getTreatmentDurationinWeeks(),4);
	}
	
	@Test
	public void testtoString() 
	{
        String s = packagedetail.toString();
        assertEquals(packagedetail.toString(), s);
    }
	

}
