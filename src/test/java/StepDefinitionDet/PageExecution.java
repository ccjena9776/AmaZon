package StepDefinitionDet;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import UtilityPack.ConfigReader;
import UtilityPack.ElementReader;
import UtilityPack.ScreenshotUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class PageExecution
{
	
 WebDriver driver = null;
 ConfigReader configKey = null;
 ElementReader elements = new ElementReader();
    
	@Given("User go to Google page")
	public void user_go_to_google_page() throws Throwable 
	{
		configKey = new ConfigReader();
		
		System.setProperty("webdriver.chrome.driver", configKey.getChromePath());
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.navigate().to(configKey.getGoogleUrl());
		driver.manage().window().maximize();
		ScreenshotUtil.captureScreenShot(driver,"Google Chrome started");
		Thread.sleep(2000);
		
	}
	@When("User pass {string} text option in the google search box")
	public void user_pass_text_option_in_the_google_search_box(String string)throws Throwable {
	  	
	  WebElement searchBox = driver.findElement(By.xpath(elements.googleSearchBoxElement()));
	    searchBox.sendKeys(string);
	    ScreenshotUtil.captureScreenShot(driver,"Amazon page name passed");
	}
	@And("User clicks on button button")
	public void user_clicks_on_button_button() throws Throwable {
	
		WebElement searchBox = driver.findElement(By.xpath(elements.googleSearchBoxElement()));
		  searchBox.sendKeys(Keys.ENTER);
            Thread.sleep(500);
	}
	@Then("User enter to the Amazon home page")
	public void user_enter_to_the_amazon_home_page() throws Throwable  {
		
	    WebElement amazonSearchlink = driver.findElement(By.xpath(elements.amazonWebsiteLink()));
	      amazonSearchlink.click();
	      ScreenshotUtil.captureScreenShot(driver,"User entered the Amazon Link");
	        Thread.sleep(1000);
	}
	@Then("User pass the book {string} in amazon search box")
	public void user_pass_the_book_in_amazon_search_box(String bookName) {
		
		WebElement amazonSearchBox = driver.findElement(By.xpath(elements.amazonSearchBox()));
	       amazonSearchBox.sendKeys(bookName);
	       ScreenshotUtil.captureScreenShot(driver,"Book Name Passed");
	}
	@Then("User click on search button")
	public void user_click_on_search_button() throws Throwable {
		
	   WebElement searchBoxButton = driver.findElement(By.xpath(elements.amazonSearchBoxButton()));
	    searchBoxButton.click();
	     Thread.sleep(1000);
	}
	
	@SuppressWarnings("deprecation")
	@Then("user go to the search reasult page and find the total books result")
	public void user_go_to_the_search_reasult_page_and_find_the_total_books_result() throws Throwable {
	    
		WebElement searchResultPage = driver.findElement(By.xpath(elements.firstBookResult()));
		  Assert.assertTrue(searchResultPage.isDisplayed());
		  ScreenshotUtil.captureScreenShot(driver,"Search result displayed for Books");
		  
		  ArrayList<String> totalBooksCount = new ArrayList<String>();
		  List<WebElement> bookList = driver.findElements(By.xpath(elements.searchBookList()));
		  
		    for(WebElement eleBook : bookList) {
		    	String altTextVerification=eleBook.getText(); 
		    	totalBooksCount.add(altTextVerification);		    	
		    }
		    
		 int countWithperticularName = totalBooksCount.size();
		 System.out.println(countWithperticularName);
		 
		  Thread.sleep(500);
	}
	@When("User change the language {string} using filter option")
	public void user_change_the_language_using_filter_option(String BookLanguage)throws Throwable  {
		  WebElement englishBookSearch = driver.findElement(By.xpath(elements.englishLanguageSearch()));
	               
		  Actions builder = new Actions(driver);
	      builder.moveToElement(englishBookSearch).click(englishBookSearch);
	      Thread.sleep(500);
	      ScreenshotUtil.captureScreenShot(driver,"English Language clicked");
	   	  builder.perform();
	      Thread.sleep(1000);	          
	}

	@Then("User finds a different count for the {string} particular book search")
	public void user_finds_a_different_count_for_the_particular_book_search(String perticularBookName) throws Exception {
		
		Actions builder = new Actions(driver);
		WebElement nextButtonClick = null ;
		 
		List<String> lostWorldBookCount = new ArrayList<String>();
		  List<WebElement> lostWorldBookList = driver.findElements(By.xpath(elements.searchBookList()));
		  
		/*1 /* for(WebElement eleBook : lostWorldBookList) {  	    	
  	    	String actualTextVerification=eleBook.getText();
  	    	if(actualTextVerification.toLowerCase().contains(perticularBookName.toLowerCase())) {  				
  				lostWorldBookCount.add(actualTextVerification);  				
  			 }
  	       }*/	
		  
		  
		/*2 /*  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		  
		  for(int i=0 ; i<= 23 ; i++) {
			  driver.switchTo().window(tabs.get(i));
			  Thread.sleep(1000);
			  
			  for(WebElement eleBook : lostWorldBookList) { 
				 
				  Thread.sleep(2000);
		  	    	String actualTextVerification=eleBook.getText();
		  	    	if(actualTextVerification.toLowerCase().contains(perticularBookName.toLowerCase())) {  				
		  				lostWorldBookCount.add(actualTextVerification);  				
		  			 }
		  	       } 
			  
		    	nextButtonClick= driver.findElement(By.xpath(elements.nextSwitchOption()));
		    	builder.moveToElement(nextButtonClick);
		    		nextButtonClick.click();
		    	  	Thread.sleep(1000);
		    	  	driver.navigate().refresh();
		    	  	Thread.sleep(1000);		    	  		    	   
			  }*/
		  
		  
		 /*3 /* for(int i=0 ; i<= lostWorldBookList.size(); i++) {
			  
			  nextButtonClick = driver.findElement(By.xpath(elements.nextSwitchOption()));
			  
	    	builder.moveToElement(nextButtonClick);
	    	if(nextButtonClick.isDisplayed()) {
	    		nextButtonClick.click();
	    	  	Thread.sleep(1000);
	    	  	driver.navigate().refresh();
	    	  	Thread.sleep(1000);	
	    	  }
	    	
	    	else	    		
	    		  driver.quit();
		    }*/ 
	    	
		  for(WebElement eleBook : lostWorldBookList) {  	    	
	  	    	String actualTextVerification=eleBook.getText();
	  	    	if(actualTextVerification.toLowerCase().contains(perticularBookName.toLowerCase())) {  	
	  	    		
	  	    		if(actualTextVerification.length() < 70) {
	  	    			
	  	    		System.out.println(actualTextVerification.length());
	  				lostWorldBookCount.add(actualTextVerification);  	
	  	    		}
	  			 }
	  	       }
		  
		  System.out.println(lostWorldBookCount);
		  driver.quit();
		  
	// NOTES :-
    // For No.- 1, it's fetching the required book names only from first page. .
	// For No.- 2, it's fetching text for required books from first page, going to next page, but there I am getting "StaleElementReference" exception. Script not working.
    // For No.-	3, It's going to each page, but not able to fetch book names from the page.
	// Last one is there only for first page, fetching book names, filtering particular ones and measuring the book name length. 	  
		  
	}
}
