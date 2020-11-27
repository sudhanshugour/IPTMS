package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDetailTest {
	
	UserDetail userdetail=new UserDetail();
	
	@Test
	void testSetName() {
		userdetail.setName("Admin");
		assertEquals("Admin",userdetail.getName());
		
	}

	@Test
	void testGetName() {
		userdetail.setName("Admin");
		assertEquals("Admin",userdetail.getName());
		
	}

	@Test
	void testUserDetailString() {
		UserDetail user=new UserDetail("Admin");
		assertEquals("Admin",user.getName());
	}

}
