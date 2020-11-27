package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthResponseTest {
	
	AuthResponse authresponse=new AuthResponse();
	@Test
	void testSetUid() {
		authresponse.setUid("1");
		assertEquals("1",authresponse.getUid());
	}

	@Test
	void testGetUid() {
		authresponse.setUid("1");
		assertEquals("1",authresponse.getUid());
	}

	@Test
	void testSetName() {
		authresponse.setName("Admin");
		assertEquals("Admin",authresponse.getName());
	}
	
	@Test
	void testGetName() {
		authresponse.setName("Admin");
		assertEquals("Admin",authresponse.getName());
	}

	@Test
	void testSetValid() {
		authresponse.setValid(true);
		assertEquals(true,authresponse.isValid());
	}
	
	@Test
	void testIsValid() {
		authresponse.setValid(true);
		assertEquals(true,authresponse.isValid());
	}

	

	@Test
	void testAuthResponseStringStringBoolean() {
		AuthResponse authrespo=new AuthResponse("1","Admin",true);
		assertEquals("Admin",authrespo.getName());
	}

	

}
