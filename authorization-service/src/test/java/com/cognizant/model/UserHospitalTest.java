package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserHospitalTest 
{
	UserHospital userHospital=new UserHospital();
	
	@Test
	public void testUserHospitalAllConstructor()
	{
		UserHospital hospital=new UserHospital("ab", "ab", "ab", null);
		assertEquals( "ab" , hospital.getUserid());
	}
	
	@Test
	public void testUserid()
	{
		userHospital.setUserid("abc");
		assertEquals( "abc",  userHospital.getUserid());
	}
	
	@Test
	public void testUserPassword()
	{
		userHospital.setUpassword("abc");
		assertEquals( "abc" , userHospital.getUpassword());
	}
	
	@Test
	public void testUserName()
	{
		userHospital.setUname("abc");
		assertEquals("abc" , userHospital.getUname());
	}
	
	@Test
	public void testAuthToken()
	{
		userHospital.setAuthToken("abc");
		assertEquals("abc", userHospital.getAuthToken());
	}
	
	@Test
	public void testoString() {
		String string = userHospital.toString();
		assertEquals(string , userHospital.toString());
	}
}
