package pages;

 
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
 
public class BasePage {
    protected AppiumDriver<MobileElement> driver;

    @SuppressWarnings("deprecation")
	@BeforeTest
    public void setUp() throws MalformedURLException {
    	 DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
         caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM A145F"); 
         caps.setCapability(MobileCapabilityType.UDID, "RK8W5048BXB");
         caps.setCapability( MobileCapabilityType.PLATFORM_VERSION, "13.0");
         caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

         caps.setCapability("appPackage","com.yasinkacmaz.jetflix.debug");
 	    caps.setCapability("appActivity","com.yasinkacmaz.jetflix.ui.main.MainActivity");
          
         System.out.println("System Started......");
 
         driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
 
          System.out.println("Driver initialized: " + (driver != null));
          
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

