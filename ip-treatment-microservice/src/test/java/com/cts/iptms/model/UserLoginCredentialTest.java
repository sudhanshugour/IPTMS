package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserLoginCredentialTest {
	
	UserLoginCredential usercredential=new UserLoginCredential();

	@Test
	void testSetUsername() {
		usercredential.setUsername("admin");
		assertEquals(usercredential.getUsername(),"admin");
	}
	
	
	@Test
	void testGetUsername() {
		usercredential.setUsername("admin");
		assertEquals("admin",usercredential.getUsername());
		
	}

	@Test
	void testGetPassword() {
		usercredential.setPassword("pass");
		assertEquals(usercredential.getPassword(),"pass");
	}

	@Test
	void testSetPassword() {
		usercredential.setPassword("pass");
		assertEquals("pass",usercredential.getPassword());
	}

}
