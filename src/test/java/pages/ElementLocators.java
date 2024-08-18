package pages;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
 
import org.openqa.selenium.By;
 import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
   
public class ElementLocators {
	
	  public static MobileElement waitForElementToBeVisible(AppiumDriver<MobileElement> driver, By locator, int timeout) {
	        return (MobileElement) new WebDriverWait(driver, timeout)
	                .until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	  public static By getMovieNameXPath(String movieName) {
		    return By.xpath(String.format("//android.widget.TextView[@text='%s']", movieName));
		}
	  
	static By buttonBack  = By.xpath("//android.view.View[@content-desc=\"Go Back\"]");
    static By searchInput = By.xpath("//android.widget.EditText") ;
    
    static By menuFilter = By.xpath("//android.view.View[@content-desc=\"Filter & Sort Movies\"]") ;
    
    static By releaseDateFilter =    By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.widget.ScrollView[2]/android.view.View[4]/android.widget.RadioButton") ;
  
    static By ascendingOrder    =    By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.widget.ScrollView[1]/android.view.View[2]/android.widget.RadioButton");
    static By closeFilter       =    By.xpath("//android.view.View[@content-desc=\"Close\"]") ;
  
    static By movieDate1Place   =    By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView[2]") ;
    static By movieDate2Place   =    By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]") ;
    static By movieDate3Place   =    By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[2]") ;
    static By movieDate4Place   =    By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView[2]") ;
}
 