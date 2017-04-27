package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class RaviScroll {
	
	public void Scrolls(String Element) throws InterruptedException
	{

	AndroidDriver driver = null;
	boolean loop=true;
				while(loop){
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
					if(driver.findElements(By.xpath(Element)).size()>0){
						loop=false;
					}
				}
}
}
