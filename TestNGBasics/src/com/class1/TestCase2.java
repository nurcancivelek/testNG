package com.class1;

import org.testng.annotations.*;

public class TestCase2 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("first");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("seventh");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("second  and fifth");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("fourth");
	}
	@Test
	public void test1() {
		System.out.println("test1=third");
	}
	@Test
	public void test2() {
		System.out.println("test2=sixth");
	}

}
