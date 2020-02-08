package com.class3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HrmsAddEmployee extends CommonMethods {

//	TC 1: HRMS Add Employee: 
//
//		Open chrome browser
//		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//		Login into the application
//		Add 5 different Employees and create login credentials by providing: 
//		First Name
//		Last Name
//		Username
//		Password
//		Provide Employee First and Last Name
//		Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
//		Close the browser
//		Specify group for this test case, add it into specific suite and execute from xml file.
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider="getData", groups="regression")
	public void addEmployees(String firstName, String lastName, String passWord) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("chkLogin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
        driver.findElement(By.id("user_name")).sendKeys(firstName+"-"+lastName);
        driver.findElement(By.id("user_password")).sendKeys(passWord);
        driver.findElement(By.id("re_password")).sendKeys(passWord);
        driver.findElement(By.id("btnSave")).submit();
        String newEmp=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getAttribute("value");
        SoftAssert softie=new SoftAssert();										//getText(); de olur
        softie.assertEquals(newEmp, firstName+" "+lastName, "new employee could not be added!");
       
        TakesScreenshot fotoSakir=(TakesScreenshot) driver;
		File screen=fotoSakir.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,  new File("screenshots/HRMS/AddEmployee"+firstName+"-"+lastName+".jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
        @DataProvider
		public Object [][] getData(){
			
			Object[][] data= {
			{"3Rachel", "Greene","t/%v+/ rIp/;0Vp"},
			{"3Monica", "Geller","t/%v+/ rIp/;0Vp"},
			{"3Phoebe", "Buffay","t/%v+/ rIp/;0Vp"},
			{"3Ross", "Geller","t/%v+/ rIp/;0Vp"},
			{"3Chandler", "Bing","t/%v+/ rIp/;0Vp"},
			};	
			return data;
		}
		
 	
	}
	

