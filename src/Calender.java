import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;

public class Calender {
	
public static AndroidDriver driver;

public static void main(String[] args) throws MalformedURLException {
	
	DesiredCapabilities cap = new DesiredCapabilities();

	cap.setCapability("deviceName", "ccdcb242");
	
	//cap.setCapability("deviceName", "emulator-5554");
	
	cap.setCapability("browserName", "Android");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "6.0.1");
	cap.setCapability("appPackage", "com.cleartrip.android");
	//cap.setCapability("appActivity", "com.cleartrip.android.activity.common.SplashActivity");
	cap.setCapability("appActivity", "com.cleartrip.android.common.activities.CleartripHomeActivity");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	/*  driver.findElement(By.id("com.cleartrip.android:id/flight_lyt_from")).click();
	  driver.findElement(By.id("com.cleartrip.android:id/filter_edittext")).clear();
	  driver.findElement(By.id("com.cleartrip.android:id/filter_edittext")).sendKeys("New Delhi");
	  driver.findElement(By.name("New Delhi, IN - Indira Gandhi Airport (DEL)")).click();
	
	driver.findElement(By.id("com.cleartrip.android:id/flight_lyt_to")).click();
	
	driver.findElement(By.id("com.cleartrip.android:id/filter_edittext")).sendKeys("Chandigarh");
	driver.findElement(By.name("Chandigarh, IN - Chandigarh (IXC)")).click();*/
	  
	  //-- This is for Selecting date form Calender--
	driver.findElement(By.id("com.cleartrip.android:id/flight_lyt_depart_date")).click();
	
	driver.scrollToExact("August 2017");
	driver.findElement(By.xpath("//android.widget.TextView[contains(@text='July 2017')]//android.view.ViewGroup[@index='2']//android.widget.TextView[@text='13']")).click();
	
//////////////////--------------------------------------------------------------------------------
	
	
	
	
	
	//-------------This is for Traveller Picker--------------------------------------
	/*driver.findElement(By.id("fhf_flightLytTravellerPicker")).click();
	
	driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.cleartrip.android:id/adultLyt']")).sendKeys("3");
	driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.cleartrip.android:id/childLyt']")).sendKeys("3");
	driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.cleartrip.android:id/infantLyt']")).sendKeys("3");*/
	//driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']//android.widget.LinearLayout[@index="))
	/*
	driver.findElement(By.id("com.cleartrip.android:id/adultLyt")).sendKeys("3");
	driver.findElement(By.id("com.cleartrip.android:id/childLyt")).sendKeys("3"); 
	driver.findElement(By.id("com.cleartrip.android:id/infantLyt")).sendKeys("3");
	*/
	/*String s = driver.findElement(By.id("android:id/custom")).findElement(By.id("com.cleartrip.android:id/adultLyt")).getText();
	System.out.println(s);
	*/
	/*driver.findElement(By.id("android:id/custom")).findElement(By.id("com.cleartrip.android:id/adultLyt")).sendKeys("3");

	
	
	driver.findElement(By.id("android:id/custom")).findElement(By.id("com.cleartrip.android:id/childLyt")).sendKeys("3");
	driver.findElement(By.id("android:id/custom")).findElement(By.id("com.cleartrip.android:id/infantLyt")).sendKeys("3");
*/	
	
/*	driver.findElement(By.id("button1")).click();*/
	
	
	
	
}


}
