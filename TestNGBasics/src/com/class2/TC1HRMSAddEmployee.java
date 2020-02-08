package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TC1HRMSAddEmployee extends CommonMethods {
//		TC 1: HRMS Add Employee: 
//		Open chrome browser
//		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//		Login into the application
//		Click on Add Employee
//		Verify labels: Full Name, Employee Id, Photograph are displayed
//		Provide Employee First and Last Name
//		Verify Employee has been added successfully
//		Close the browser

	 @BeforeMethod
	    public void open() {
	        setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	    }
	    @AfterMethod
	    public void close() {
	        driver.close();
	    }
	    @Test(groups="regression")
	    public void addingEmployee() throws InterruptedException {
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        
	        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	      
	        driver.findElement(By.id("btnLogin")).click();
	       // Actions act= new Actions(driver);
	        //WebElement pim=
	        driver.findElement(By.linkText("PIM")).click();
	        //act.moveToElement(pim);
	        Thread.sleep(2000);
	       driver.findElement(By.id("menu_pim_addEmployee")).click();
	        
	        boolean fullname=driver.findElement(By.xpath("//label[text()='Full Name']")).isDisplayed();
	        SoftAssert sa= new SoftAssert();
	        sa.assertTrue(fullname, "Full name Displayed");
	        if(fullname) 
	        	System.out.println("Full name is displayed");
	        
	        boolean employeeId=driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
	        sa.assertTrue(employeeId, "Employee Id displayed");
	        if(employeeId)
	        	System.out.println("Employee id is displayed");
	        
	        boolean photo=driver.findElement(By.xpath("//label[text()='Photograph']")).isDisplayed();
	        sa.assertTrue(photo, "Photograph is displayed");
	        if(photo)
	        	System.out.println("photo is displayed");
	        
	        driver.findElement(By.id("firstName")).sendKeys("yineMi");
	     
	        driver.findElement(By.id("lastName")).sendKeys("addEmployee");
	       
	        driver.findElement(By.id("btnSave")).click();
	        Thread.sleep(3000);
	        String name="yineMi Employee";
	        boolean verify=driver.findElement(By.xpath("//h1[text()='yineMi addEmployee']")).isDisplayed();
	        sa.assertTrue(verify, "Employee is added");
	        if(verify)
	        	System.out.println("Employee "+name+ " is succesfully added!");
	        
	    }
}
