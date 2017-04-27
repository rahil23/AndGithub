
	
	import java.net.URL;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

	public class Emulator {

	 AndroidDriver driver;

	 @Test
	 public void setUp() throws Exception {

	  // Created object of DesiredCapabilities class.
	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  // Set android deviceName desired capability. Set it Android Emulator.
	  capabilities.setCapability("deviceName", "");

	  // Set browserName desired capability. It's Android in our case here.
	 // capabilities.setCapability("browserName", "Android");

	  // Set android platformVersion desired capability. Set your emulator's android version.
	  //capabilities.setCapability("platformVersion", "7.0");

	  // Set android platformName desired capability. It's Android in our case here.
	  //capabilities.setCapability("platformName", "Android");

	  // Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
	  // Set your application's appPackage if you are using any other app.
	  capabilities.setCapability("appPackage", "com.sears.android");

	  // Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
	  // Set your application's appPackage if you are using any other app.
	  capabilities.setCapability("appActivity", "com.android.sears.activity.MenuDrawerActivity");

	  // Created object of RemoteWebDriver will all set capabilities.
	  // Set appium server address and port number in URL string.
	  // It will launch calculator app in emulator.
	  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	  // Click on CLR button.
	 driver.quit();
	 }
	}


