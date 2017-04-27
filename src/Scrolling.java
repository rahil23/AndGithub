import java.net.MalformedURLException;

import utility.RaviScroll;
import utility.Scroll;
import utility.Scroll3;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Scrolling
{
	
	
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
	public void scrollBegin() throws InterruptedException
	{ 
		
		driver.findElement(By.name("Views")).click();
	
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		JavascriptExecutor js = (JavascriptExecutor)driver; 
//	RemoteWebElement element = null;
//		String widId = ((RemoteWebElement) element).getId(); 
//		scrollObject.put("text", "Tabs"); 
//		scrollObject.put("element", "//android.widget.TextView[@text='Tabs']"); 
//		js.executeScript("mobile: scrollTo", scrollObject);
	
		
		
		
//	MobileElement radioGroup = (MobileElement)driver
//			.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
//	         +".text(\"Tabs\")).scrollIntoView("
//	         + "new UiSelector().text(\"Tabs\"));");
//
//			radioGroup.click();
//		
//		
//	driver.findElement(By.name("Views")).click();
		
	//	Scroll obj = new Scroll();
		//obj.scrolls("Views");
	
//	Scroll3 obj2 = new Scroll3();
//	obj2.scrollDownToAnElement("//android.widget.TextView[@text='Tabs']");
//		
////	RaviScroll obj2 = new RaviScroll();
////	obj2.Scrolls("//android.widget.TextView[@text='Tabs']");
//      System.out.println("Scrolling is done to views");
//
//	
//		System.out.println("Scrolled till Tabs");
//		
//		driver.findElement(By.name("Tabs")).click();
		
		
		
		
		boolean loop=true;
		int count=0;
		while(loop){
			if(count==5)
				break;
			if(driver.findElements(By.xpath("//android.widget.TextView[@text='Tabs']")).size()>0){
				loop=false;
			}
			else{
			Dimension size = driver.manage().window().getSize();
			System.out.println(size);
			//Find swipe start and end point from screen's with and height.
			//Find starty point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
			//Find endy point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			//Find horizontal point where you wants to swipe. It is in middle of screen width.
			int startx = size.width / 2;
			System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
			//Swipe from Bottom to Top.
			((AndroidDriver) driver).swipe(startx, starty, startx, endy, 3000);
			Thread.sleep(1000);
			count++;
		}
			//Swipe from Top to Bottom.
			//		  ((AndroidDriver) driver).swipe(startx, endy, startx, starty, 3000);
			
		//	driver.findElement(By.name("Tabs")).click();
		}
		driver.findElement(By.name("Tabs")).click();
		
		
				
	}
	@AfterTest
	public void end()
	{
		driver.quit();
	}
	
	
}
