package com.class3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class CalendarPractice  extends CommonMethods{
	
	public static void main(String[] args) throws InterruptedException {
		
	
	
	    setUp("chrome", "https://www.southwest.com");
		
//		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.
//		driver.findElement(By.xpath("//div[@class='input input_left input_secondary list-box--input']/input")).clear();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//div[@class='input input_left input_secondary list-box--input']/input")).sendKeys("RDU");
//		driver.findElement(By.xpath("//div[@class='input input_error input_icon input_left input_secondary list-box--input']/input")).sendKeys("LAX");
//		driver.findElement(By.xpath("//div[@class='input input_error input_icon input_left input_secondary list-box--input']/input")).click();
		
		driver.findElement(By.xpath("//input[@id='LandingAirBookingSearchForm_departureDate']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String departing=driver.findElement(By.xpath("//div[@class='calendar-month']/div[1]")).getText();
		System.out.println(departing);
		if(departing.equals("Jun 2020")) {
			WebElement depdate=driver.findElement(By.xpath("//div[@class='calendar-month']/div[10]"));
		}
		
		
		
	}
	
	
}
