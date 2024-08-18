package pages;

 
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
 
public class HomePage extends BasePage {
	private AppiumDriver<MobileElement> driver;

    // Constructor
    public HomePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Method to click on the movie name
    public void clickOnMovieName(String movieName) {
    	 By movieNameLocator = ElementLocators.getMovieNameXPath(movieName);
         MobileElement movieNameElement = ElementLocators.waitForElementToBeVisible(driver, movieNameLocator, 10);
 
        movieNameElement.click();
 
    }

    // Method to retrieve the movie name text
    
    public String getMovieName(String movieName)   {
    	 By movieNameLocator = ElementLocators.getMovieNameXPath(movieName);
         MobileElement movieNameElement = ElementLocators.waitForElementToBeVisible(driver, movieNameLocator, 10);
         return movieNameElement.getText();
    }
    
    public void clickMenuFilter() {
         MobileElement MenuFilterElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.menuFilter, 10);
         MenuFilterElement.click();
     }

    public void chooseReleaseDateFilter() {
    	  MobileElement ReleaseDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.releaseDateFilter, 20);
    	  ReleaseDateElement.click();
    }

     public void chooseSortOrderAscending() {
    	 MobileElement ReleaseDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.ascendingOrder, 10);
   	     ReleaseDateElement.click();
     }

    public void closeMenuFilter() {
    	 MobileElement ReleaseDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.closeFilter, 10);
   	     ReleaseDateElement.click();   
   	     }
    
    public String getMovieDateOfFirstPlace ()   {
    	MobileElement movieDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.movieDate1Place, 10);
        return movieDateElement.getText();
   }
    public String getMovieDateOfSecondPlace ()   {
    	MobileElement movieDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.movieDate2Place, 10);
        return movieDateElement.getText();
   }
    public String getMovieDateOfThirdPlace ()   {
    	MobileElement movieDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.movieDate3Place, 10);
        return movieDateElement.getText();
   }
    public String getMovieDateOfFourthPlace ()   {
    	MobileElement movieDateElement = ElementLocators.waitForElementToBeVisible(driver, ElementLocators.movieDate4Place, 10);
        return movieDateElement.getText();
   }
    public List <String> getVisibleFilmDates() {
    	
       return Arrays.asList(getMovieDateOfFirstPlace(), getMovieDateOfSecondPlace(), getMovieDateOfThirdPlace(), getMovieDateOfFourthPlace());
   }
    
    public void scrollDown() { 
    	
    	Dimension screenSize = driver.manage().window().getSize();
       
        int startX = screenSize.width / 2;
        int startY = screenSize.height / 2;
        int endY = startY - 1840;
        
        TouchAction<?> action = new TouchAction<>(driver);
        action.press(PointOption.point(startX, startY))
              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
              .moveTo(PointOption.point(startX, endY))
              .release()
              .perform();
    	 
    }
    
     public void checkFutureFilms() {
    	 boolean hasMoreFilms = true;
    	 List<String> previousFilmDates = getVisibleFilmDates();
     	 
	      while (hasMoreFilms) {
	    	  
              for (String dateText : getVisibleFilmDates() ) { 
	    	  
                  System.out.println(dateText); 
                  
                  if (dateText != null && dateText.length() == 10) {
                      try {
                          LocalDate releaseDate = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                          LocalDate today = LocalDate.now();
                          Assert.assertTrue(releaseDate.isAfter(today), "The movie release date " + releaseDate + " is not in the future");


                      } catch (DateTimeParseException e) {
              	        System.out.println("......." );

                       }
                  } else {
          	        System.out.println("......." );

                   }
                  
                  
         }
	        System.out.println("All Dates in the Future" );
	        System.out.println("......." );
	        System.out.println("Scrolling....." );
 	        scrollDown();
	    
	        List<String> currentFilmDates =  getVisibleFilmDates();

        if (previousFilmDates.equals(currentFilmDates)) {
               hasMoreFilms = false;
  }            
        else {
      previousFilmDates = currentFilmDates; 
  }  
            
	        }}
	          	
    }
    


