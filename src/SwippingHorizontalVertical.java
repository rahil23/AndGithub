import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.CanPerformActionChain;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SwippingHorizontalVertical {
	
	AndroidDriver driver;
	Dimension size;
	
@BeforeTest
public void start() throws MalformedURLException
{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	capabilities.setCapability("deviceName", "ccdcb242");
	capabilities.setCapability("browserName", "Android");
	capabilities.setCapability("platformVersionName", "5.1.1");
	capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appActivity","com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
}

@Test
public void swipeHorizontal() throws InterruptedException
{
	size = driver.manage().window().getSize();
	
	System.out.println(size);
	
	int startx = (int) (size.width *  0.70);
int endx =  (int) (size.width * 30);	

int starty = size.height/2;

System.out.println("startx = "+  startx);
System.out.println("starty = "+ starty);
System.out.println("endx = " + endx);

//Swipe from right to left
driver.swipe(startx, starty, endx, starty, 3000);
Thread.sleep(2000);

//Swipe from left to right
driver.swipe(endx, starty, startx, starty, 3000);
Thread.sleep(2000);
}
@Test
public void swipingVertical() throws InterruptedException
{
	size = driver.manage().window().getSize();
System.out.println(size);

int ver_start_y =  (int) (size.height * 0.80);
int ver_end_y = (int)(size.height * 0.20);

int ver_start_x = size.width/2;

System.out.println("ver_start_y = "+ ver_start_y );
System.out.println("ver_start _x = "+ ver_start_x);
System.out.println("ver_end_y = "+ ver_end_y);

driver.swipe(ver_start_x, ver_start_y, ver_start_x, ver_end_y, 3000);
Thread.sleep(2000);

driver.swipe(ver_start_x, ver_end_y, ver_start_x, ver_start_y, 3000);

Thread.sleep(2000);
}

@AfterTest
public void End() 
{
	driver.quit();
}


}
