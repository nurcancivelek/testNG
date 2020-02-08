package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {


	public static WebDriver driver;

	public static void setUp(String browser, String url){

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
			driver=new ChromeDriver();
			//driver.get(url);

		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver=new FirefoxDriver();
			//driver.get(url);
		}else {
			System.err.println("Browser not supported!");
		}
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}

//	public static WebDriver setUp(String browser){
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
//			driver=new ChromeDriver();
//		
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//			driver=new FirefoxDriver();
//		}
//		
//		return driver;
//	}
	
	//ALert Methods
	  public static void AcceptAlert() {
	      
	          try{
	              Alert alert=driver.switchTo().alert();
	              alert.accept();
	          }catch(NoAlertPresentException e) {
	              System.out.println("Alert is not present");
	          }
	      }
	  /**
	   * this method will dismiss the alert 
	   * @throws will throw NoAlertExeption if alert is not present.
	   */
	  public static void dismissAlert() {
	  
	      try{
	          Alert alert=driver.switchTo().alert();
	          alert.dismiss();
	      }catch(NoAlertPresentException e) {
	          System.out.println("Alert is not present");
	      }
	  }
	  /**
	   * this method will accept the alert 
	   * @throws will throw NoAlertExeption if alert is not present.
	   */
	  public static String getTextAlert() {
	      
	      try{
	          Alert alert=driver.switchTo().alert();
	          
	          return alert.getText();
	      }catch(NoAlertPresentException e) {
	          System.out.println("Alert is nor present");
	          return null;
	      }
	  }

	public static String getAlertText() {
        String alertText=null;
        try {
            Alert alert=driver.switchTo().alert();
             alertText=alert.getText();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert is not present");
        }
        return alertText;
    }
/*
 * try{
 * aler talert=driver.switchTo().alert();
 * return alert.getText()						bu da olur!!!
 * }catch(NoAlertPresentException e) {
    System.out.println("Alert is not present");
     return null;       
        }
; */
				//FRAME METHODS
	//this method will switch to the frame
	//@param name or id
	public static void switchToFrame(String nameOrId) {
		
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	//this method will switch to the frame
		//@param element
	public static void switchToFrame(WebElement element) {
		
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	//this method will switch to the frame
			//@param index
public static void switchToFrame(int index) {
		
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
}
/**
 * This method will click on the element using JSExecutor
 * @param element
 */
public static void jsClick(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
}

/**
 * This method will scroll until until specified element
 * @param element
 */
public static void scrollIntoElement(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);
}

/**
 * This method will scroll page down
 * @param pixel
 */
public static void scrollDown(int pixel) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0," + pixel + ")");
}

/**
 * This method will scroll page up
 * @param pixel
 */
public static void scrollUp(int pixel) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, -" + pixel + ")");
}

/**
 * this method will take a screenshot
 * @param fileName
 */
public static void takeScreenshot(String fileName) {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File file=ts.getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file,  new File("screenshot"+fileName+".png"));
	}catch(IOException e){
		System.out.println("Cannot take screenshot");
	}
}



//public static void jsClick(WebElement element) {
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].click();", element);
//}
//public static void scrollIntoElement(WebElement element) {
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true);", element);
//}
//public static void scrollDown(int pixel) {
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollBy(0," + pixel + ")");
//}
//public static void scrollUp(int pixel) {
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollBy(0,-" + pixel + ")");
//}

}

