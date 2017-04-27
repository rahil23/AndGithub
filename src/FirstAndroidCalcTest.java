import org.testng.annotations.Test;
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

public class FirstAndroidCalcTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "ccdcb242");
		
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
	    
	    capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
	    
	    capabilities.setCapability("platformName", "Android");
	    
	    capabilities.setCapability("appPackage", "com.digitalchemy.calculator.freedecimal");
	    
	    capabilities.setCapability("appActivity", "com.digitalchemy.calculator.droidphone.CalculatorMainActivity");
	    
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	    
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   
	}
	
	@Test
	public void sum()  {
	
		driver.findElement(By.className("android.widget.ImageView")).click();
		driver.findElement(By.xpath("//*[contains(@resource-id,'n7')]")).click();
		driver.findElement(By.xpath("//*[contains(@resource-id,'multiply')]")).click();
		driver.findElement(By.xpath("//*[contains(@resource-id,'n4')]")).click();
		driver.findElement(By.xpath("//*[contains(@resource-id,'equals')]")).click();
		
		String result = driver.findElement(By.className("android.widget.RelativeLayout")).getText();
		
		System.out.println("RESULT of Multiply" + " : " + result);
	}
	
	@AfterTest
public void close()  {
		driver.quit();
	}
			}


