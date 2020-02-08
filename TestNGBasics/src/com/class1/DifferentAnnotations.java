package com.class1;

import org.testng.annotations.*;

public class DifferentAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	@Test
	public void test() {
		System.out.println("i am an actual test");
	}

	
	
}
