package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserHospitalTest {
	
	UserHospital userhospital=new UserHospital();
	
	@Test
	void testSetUserid() {
		userhospital.setUserid("12ab");
		assertEquals(userhospital.getUserid(), "12ab");
	}

	@Test
	void testGetUserid() {
		userhospital.setUserid("12ab");
		assertEquals("12ab",userhospital.getUserid());
	}

	
	@Test
	void testSetUpassword() {
		userhospital.setUpassword("123@abc");
		assertEquals(userhospital.getUpassword(),"123@abc");
	}


	@Test
	void testGetUpassword() {
		userhospital.setUpassword("123@abc");
		assertEquals("123@abc",userhospital.getUpassword());
	}

	
	@Test
	void testSetUname() {
		userhospital.setUname("User1");
		assertEquals(userhospital.getUname(),"User1");
				
	}
	
	@Test
	void testGetUname() {
		userhospital.setUname("User1");
		assertEquals("User1",userhospital.getUname());
	}
	
	@Test
	void testSetAuthToken() {
		userhospital.setAuthToken("123wer");
		assertEquals(userhospital.getAuthToken(),"123wer");
	}

	@Test
	void testGetAuthToken() {
		userhospital.setAuthToken("123wer");
		assertEquals("123wer",userhospital.getAuthToken());
	}


	@Test
	void testUserHospitalStringStringStringString() {
		UserHospital userHospital=new UserHospital("12ab","123@abc","User1","123wer");
		assertEquals(userHospital.getUname(),"User1");
	}

	@Test
	void testToString() {
		String s=userhospital.toString();
		assertEquals(userhospital.toString(),s);
	}

}
