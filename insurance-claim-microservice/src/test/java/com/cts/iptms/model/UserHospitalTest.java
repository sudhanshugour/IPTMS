package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserHospitalTest {
	
	UserHospital userhospital=new UserHospital();

	
	@Test
	void testSetUserid() {
		userhospital.setUserid("2");
		assertEquals("2",userhospital.getUserid());
	}
	
	@Test
	void testGetUserid() {
		userhospital.setUserid("2");
		assertEquals("2",userhospital.getUserid());
		
		
	}
	
	@Test
	void testSetUpassword() {
		userhospital.setUpassword("12@abc");
		assertEquals("12@abc",userhospital.getUpassword());
	}
	

	@Test
	void testGetUpassword() {
		userhospital.setUpassword("12@abc");
		assertEquals("12@abc",userhospital.getUpassword());
	}
	
	@Test
	void testSetUname() {
		userhospital.setUname("ABC");
		assertEquals("ABC",userhospital.getUname());
	}

	@Test
	void testGetUname() {
		userhospital.setUname("ABC");
		assertEquals("ABC",userhospital.getUname());
	}
	
	@Test
	void testSetAuthToken() {
		userhospital.setAuthToken("123dfg");
		assertEquals("123dfg",userhospital.getAuthToken());
		
	}

	@Test
	void testGetAuthToken() {
		userhospital.setAuthToken("123dfg");
		assertEquals("123dfg",userhospital.getAuthToken());
	}


	@Test
	void testUserHospitalStringStringStringString() {
		UserHospital user=new UserHospital("2","12@abc","ABC","123dfg");
		assertEquals("ABC",user.getUname());
	}

	@Test
	void testToString() {
		String s=userhospital.toString();
		assertEquals(userhospital.toString(),s);
	}

}
