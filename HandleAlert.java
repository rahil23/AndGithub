import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class HandleAlert {
	
	AndroidDriver driver;
  @BeforeTest
  public void setup() {
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("devicename", "ccdcb242");
     	capabilities.setCapability("browserName", "ANDROID");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		capabilities.setCapability("appActivity","com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  WebDriverWait wait = new WebDriverWait(driver, 300);
		  wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
  }

  @Test
  public void swipingHorizontal() throws InterruptedException {
   //Get the size of screen.
   size = driver.manage().window().getSize();
   System.out.println(size);
   
   //Find swipe start and end point from screen's with and height.
   //Find startx point which is at right side of screen.
   int startx = (int) (size.width * 0.70);
   //Find endx point which is at left side of screen.
   int endx = (int) (size.width * 0.30);
   //Find vertical point where you wants to swipe. It is in middle of screen height.
   int starty = size.height / 2;
   System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

   //Swipe from Right to Left.
   driver.swipe(startx, starty, endx, starty, 3000);
   Thread.sleep(2000);

   //Swipe from Left to Right.
   driver.swipe(endx, starty, startx, starty, 3000);
   Thread.sleep(2000);
  }

  @Test
  public void swipingVertical() throws InterruptedException {
   //Get the size of screen.
   size = driver.manage().window().getSize();
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
   driver.swipe(startx, starty, startx, endy, 3000);
   Thread.sleep(2000);
   //Swipe from Top to Bottom.
   driver.swipe(startx, endy, startx, starty, 3000);
   Thread.sleep(2000);
  }

  @AfterTest
  public void End() {
   driver.quit();
  }

  }
}
