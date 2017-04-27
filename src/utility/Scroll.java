package utility;

import io.appium.java_client.android.AndroidDriver;

 
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

 
public class Scroll

{
	
 	static AndroidDriver driver;
 		 		
   public void scrolls(String Element) 
   {
	    while(driver.findElements(By.name(Element)).size()==0)
		{
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0,scrollStart,0,scrollEnd,2000);
		}
	
		if(driver.findElements(By.name(Element)).size()>0)
		{
			driver.findElement(By.name(Element)).click();
		}   
	
	}
 	}
