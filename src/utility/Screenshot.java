package utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import io.appium.java_client.android.AndroidDriver;


public class Screenshot {
	
	AndroidDriver driver;
	 String destDir;
	DateFormat dateFormat;
	@BeforeTest
	void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ccdcb242");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.1");
		 capabilities.setCapability("appPackage", "io.appium.android.apis");
		  capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void scrollTab()
	{
		driver.unlockDevice();		
		driver.findElement(By.name("App")).click();
		driver.findElement(By.name("Alert Dialogs")).click();
		driver.findElement(By.name("OK Cancel dialog with a message")).click();
		  String result = driver.findElementById("android:id/alertTitle").getText();
		  System.out.println("Alert text Is -> " + result);
		  
		  driver.findElement(By.name("OK")).click();
		  
		//  takeScreenshot();
	}
//	public void takeScreenShot() {
//		  // Set folder name to store screenshots.
//		  destDir = "screenshots";
//		  // Capture screenshot.
//		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		  // Set date format to set It as screenshot file name.
//		  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
//		  // Create folder under project with name "screenshots" provided to destDir.
//		  new File(destDir).mkdirs();
//		  // Set file name using current date time.
//		  String destFile = dateFormat.format(new Date()) + ".png";
//
//		  try {
//		   // Copy paste file at destination folder location
//		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
//		   
//		   
//		  } catch (IOException e) {
//		   e.printStackTrace();
//		  }
//		 }
	
	
	
	public void screenshot(String path_screenshot) throws IOException{
	    File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    File targetFile=new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
	}
	
	@AfterTest
	public void End()
	{
		driver.quit();
	}

}
