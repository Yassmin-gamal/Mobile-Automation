package example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class Scenario2  extends BasePage {
 
     @Test 
     public void testReleaseDateFilter() {
    	 
	        HomePage homePage = new HomePage(driver);
            
	        homePage.clickMenuFilter();
	        homePage.chooseReleaseDateFilter();
	        homePage.chooseSortOrderAscending();
 	        homePage.closeMenuFilter();
	        
	        String dateText = homePage.getMovieDateOfFirstPlace();
	        System.out.println("Retrieved text: " + dateText);

	        LocalDate releaseDate = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
	        LocalDate today = LocalDate.now();

	        Assert.assertTrue(releaseDate.isAfter(today), "The movie release date " + releaseDate + " is not in the future");
     }
     
       


}