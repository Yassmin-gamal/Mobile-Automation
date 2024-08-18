package example;
   
 import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class Scenario2AnotherSolution extends BasePage{

	 @Test 
     public void testReleaseDateFilter() {
    	 
	        HomePage homePage = new HomePage(driver);
            
	        homePage.clickMenuFilter();
	        homePage.chooseReleaseDateFilter();
  	        homePage.closeMenuFilter();
  	        homePage.checkFutureFilms();
     }
 
}

