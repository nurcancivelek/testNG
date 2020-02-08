package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class SoftAssertionDemo extends CommonMethods{
	
	/* Open Application
	 * Verify logo is displayed
	 * Enter valid credentials
	 * Verify user successfully logged in
	 */
	
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	
	@Test
	public void logoAndLogin() {
		boolean logoDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
		//hard assertion will fail and execution will stop at that point
		//so we use soft assertion
		//Assert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		
		//soft assertion
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("btnLogin")).click();
		
		boolean welcomeDisplayed=driver.findElement(By.id("welcome")).isDisplayed();
		Assert.assertTrue(welcomeDisplayed, "Welcome element is NOT displayed");
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
