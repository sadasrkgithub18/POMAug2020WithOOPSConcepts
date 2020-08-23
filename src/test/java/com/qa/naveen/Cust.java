package com.qa.naveen;

import org.testng.annotations.Test;

public class Cust {
	@Test(enabled = true)
	public void testAAA()
	{
		System.out.println("Hello....AA....");
	}
	
	@Test
	public void testBAB()
	{
		System.out.println("Hello....BB....");
	}
	
	@Test
	public void testCAC()
	{
		System.out.println("Hello....CC....");
	}
	
}
