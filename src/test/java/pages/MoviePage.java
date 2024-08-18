package pages;

 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MoviePage extends BasePage {
    private   AppiumDriver<MobileElement> driver;

    // Constructor
    public MoviePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void searchForMovie(String movieName) {
          MobileElement searchInputLocator = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.searchInput, 10); 
          
          searchInputLocator.click();
          searchInputLocator.clear();
          searchInputLocator.sendKeys(movieName);
  
    }

   
    public String getMovieNameFromMoviePage(String movieName)  {
   	 By movieNameLocator = ElementLocators.getMovieNameXPath(movieName);
     MobileElement movieNameElement = ElementLocators.waitForElementToBeVisible(driver, movieNameLocator, 10);
     return movieNameElement.getText();
 
    }
    
    public void clickBack() {
         MobileElement backButtonElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.buttonBack, 10); 
        backButtonElement.click();
    }
    
 
 
}

