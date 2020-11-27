package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDetailTest {
	
	UserDetail userdetails=new UserDetail();

	@Test
	void testUserDetailString() {
		UserDetail userdetail=new UserDetail("Ron");
		assertEquals(userdetail.getName(),"Ron");
		
	}

	@Test
	void testGetName() {
		userdetails.setName("Ron");
		assertEquals(userdetails.getName(),"Ron");
	}

	@Test
	void testSetName() {
		userdetails.setName("Ron");
		assertEquals("Ron",userdetails.getName());
	}

}
