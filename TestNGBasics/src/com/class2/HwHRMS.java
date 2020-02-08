package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * TC 1: HRMS Application Login: 
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username and password
Click on login button
Then verify Syntax Logo is displayed
Close the browser


TC 2: HRMS Application Negative Login: 
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.
 */

public class HwHRMS extends CommonMethods{
	@BeforeMethod(alwaysRun=true)
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
		
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@Test(groups="regression")
	public void validationOfLogo() {
		boolean logo=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		String expectedTitle=driver.getTitle();
		String actualTitle="Human Management System";
		System.out.println(expectedTitle);
		
		Assert.assertEquals(expectedTitle, actualTitle, "expected and actual titles are same");
	}
	@Test(groups="regression")
	public void validationOfLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean loggedIn=driver.findElement(By.id("welcome")).isDisplayed();
		Assert.assertTrue(loggedIn);
		boolean logoDisplayed=driver.findElement(By.xpath("//div[@id='branding']/a/img")).isDisplayed();
		Assert.assertTrue(logoDisplayed);
		
	}
	@Test(groups="regression")
	public void emptyUsername() {
		driver.findElement(By.id("txtUsername")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		String expected=driver.findElement(By.id("spanMessage")).getText();
		String actual="Username cannot be empty";
		boolean span=driver.findElement(By.id("spanMessage")).isDisplayed();
		Assert.assertEquals(actual, expected);
	}
	@Test(groups="regression")
	public void emptyPassword() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();
		String expected=driver.findElement(By.xpath("//div[@id='divLoginButton']/span")).getText();
		String actual="Password cannot be empty";
		Assert.assertEquals(actual, expected);
		
	}
	@Test(groups="regression")
	public void wrongUsername() {
		driver.findElement(By.id("txtUsername")).sendKeys("Adm");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		String expected=driver.findElement(By.xpath("//div[@id='divLoginButton']/span")).getText();
		String actual="Invalid credentials";
		Assert.assertEquals(expected, actual);
		
	}
	@Test(groups="regression")
	public void wrongPassword() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm");
		driver.findElement(By.id("btnLogin")).click();
		String expected=driver.findElement(By.xpath("//div[@id='divLoginButton']/span")).getText();
		String actual="Invalid credentials";
		Assert.assertEquals(expected, actual);
		
	}

}
