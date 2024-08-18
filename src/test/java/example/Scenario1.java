package example;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.BasePage;

import pages.HomePage;
import pages.MoviePage;

 
import org.testng.Assert;

	public class Scenario1 extends BasePage {
		
		@DataProvider(name = "movieNames")
		public Object[][] movieNames() {
		    return new Object[][] {
		    	{"It Ends with Us"},
 		        {"Deadpool & Wolverine"},
		        {"Twisters"}
		    };
		}
		
		
		@Test(dataProvider = "movieNames")
		public void verifyMovieNameConsistency(String movieName) {
 
	        HomePage homePage = new HomePage(driver);
	        MoviePage moviePage = new MoviePage(driver);


 
	        // Click on the movie name on the home screen
	         moviePage.searchForMovie(movieName); 
            
	        // Step 1: Retrieve the movie name from the home screen
	        String expectedMovieName = homePage.getMovieName(movieName);

	        // Step 2: Click on the movie name
	        homePage.clickOnMovieName(movieName);

	        // Step 3: Retrieve the movie name from the movie screen
 	 
	        String actualMovieName = moviePage.getMovieNameFromMoviePage(movieName);

	        // Assert that the movie name on the home screen is the same on the movie screen
	        Assert.assertEquals(expectedMovieName, actualMovieName, "Movie names do not match!");
	        moviePage.clickBack();
	        
	    }
		
	}