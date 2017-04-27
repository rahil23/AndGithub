import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragNDrop {
	//AndroidDriver driver;
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException 
	{ 
//		File classpathroot = new File(System.getProperty("user.dir"));
//		
//		File appDir = new File(classpathroot,"//APK FIles");
//		
//		File app = new File(appDir,"com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "ccdcb242");
		capabilities.setCapability("browserName", "ANDROID");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", " com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity"," com.mobeta.android.demodslv.Launcher");
		
		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
	
	@Test
	public void dragDrop()
	{
		//driver.findElementByName("Basic usage playground").click();
		
		driver.findElement(By.name("Basic usage playground")).click();
		
	WebElement ele1 = 	driver.findElement(By.name("Chick Corea"));

WebElement ele2  = driver.findElement(By.name("Michael Brecker"));


TouchAction action = new TouchAction((MobileDriver) driver);  // type cast Android driver to MobileDriver

System.out.println("It's a dragging element");

action.longPress(ele1).moveTo(ele2).release().perform();
System.out.println("Element moved Successfully");

	}
	
	
	@AfterTest
	public void end() 
	{ 
		driver.quit();
	}
	

}

