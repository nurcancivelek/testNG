package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task1 extends CommonMethods {
    @BeforeMethod
    public void open() {
        setUp("chrome", Constants.HRMS_URL);
    }
    @AfterMethod
    public void close() {
        driver.close();
    }
    @Test(priority=2)
    public void validationOfLogo() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        boolean isTrue = driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
        Assert.assertTrue(isTrue, "Syntax Logo is displayed");
    }
    @Test(priority=1)
    public void validationOfMessage() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();
        WebElement error = driver.findElement(By.id("spanMessage"));
        String expectedError="Password cannot be empty";
        if (error.isDisplayed()) {
            Assert.assertEquals(expectedError, error, "Erorr msg is correct. Test Pass");
        } else {
            System.out.println("error is NOT displayed. Test Fail");
        }
    }
}