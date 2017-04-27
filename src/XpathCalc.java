import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class XpathCalc {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "ccdcb242");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "ANDROID");
		capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
		capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("appPackage", "com.digitalchemy.calculator.freedecimal");
		    
		    capabilities.setCapability("appActivity", "com.digitalchemy.calculator.droidphone.CalculatorMainActivity");
		    
		    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		    
		   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void launch()
	{
		driver.findElements(By.xpath("//android.widget.ImageView")).get(10).click();
		driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/n9")).click();
		driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/multiply")).click();
		driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/n6")).click();

		driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/equals")).click();
		
		
		String result = driver.findElement(By.className("android.widget.RelativeLayout")).getText();
		
		System.out.println("REsult is "  + result);
		
		
	}
	
	
	@AfterTest
	public void closeWindow()
	{
		driver.quit();
	}
	}

