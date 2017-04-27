import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class alertClick {
	
	@SuppressWarnings("rawtypes")
	AndroidDriver driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeTest
    public void start() throws MalformedURLException	
  {
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability("deviceName", "ccdcb242");
		capabilites.setCapability("browserName", "Android");
		capabilites.setCapability("platformName", "Android");
        capabilites.setCapability("platformversion", "5.1.1");		
		capabilites.setCapability("appPackage", "io.appium.android.apis");
		capabilites.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   }

	@Test
	public void scrollBegin() 
	{ 
		driver.unlockDevice();		
		driver.findElement(By.name("App")).click();
		driver.findElement(By.name("Alert Dialogs")).click();
		driver.findElement(By.name("OK Cancel dialog with a message")).click();
		  String result = driver.findElementById("android:id/alertTitle").getText();
		  System.out.println("Alert text Is -> " + result);
		  
		  driver.findElement(By.name("OK")).click();
		//  driver.lockDevice();
		  //driver.unlockDevice();
		  

	}
		
	
	@AfterTest
	public void end()
	{
		driver.quit();
	}
}
