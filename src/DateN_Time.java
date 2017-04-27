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

public class DateN_Time {

	AndroidDriver driver;
	
	@BeforeTest
public void setup() throws MalformedURLException
{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ccdcb242");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
	
	@Test
	public void execute() throws InterruptedException
	{
		driver.findElement(By.name("Views")).click();
		driver.findElement(By.name("Date Widgets")).click();
		driver.findElement(By.name("1. Dialog")).click();
		
	driver.findElement(By.name("change the date")).click();
	
	driver.findElement(By.xpath("//android.view.View[@index='14']")).click();
	driver.findElement(By.id("android:id/date_picker_year")).click();
	
	
	boolean loop=true;
	int count=0;
	while(loop){
		if(count==5)
			break;
		if(driver.findElements(By.id("android:id/month_text_view")).size()>0){
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
		} }
	driver.findElement(By.xpath("//android.widget.TextView[@text='1992']")).click();
	}
	@AfterTest
	public void end()
	{
		//driver.quit();
	}
	
}
