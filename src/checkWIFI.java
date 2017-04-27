import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class checkWIFI {
	static AndroidDriver driver;
	
public static void main(String[] args) throws MalformedURLException {
	DesiredCapabilities cap = new DesiredCapabilities();

	
	
	
	
	cap.setCapability("deviceName", "Andoird Emulator");
	cap.setCapability(CapabilityType.BROWSER_NAME, "ANDROID");
	cap.setCapability(CapabilityType.VERSION, "5.1.1");
	cap.setCapability("platformName", "Android");
	  
	    
	    driver = new AndroidDriver(new URL("http://0.0.0.0:4727/wd/hub"),cap);
	    
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   
	   driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Settings\")").click();
	   
}

}
