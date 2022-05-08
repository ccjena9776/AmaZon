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
		  
		  ArrayList<String> lostWorldCount = new ArrayList<String>();
		  List<WebElement> bookList = driver.findElements(By.xpath(elements.searchBookList()));
		  
		    for(WebElement eleBook : bookList) {
		    	String altTextVerification=eleBook.getAttribute("alt");
		    	
		    	if(altTextVerification.contains("The Lost World")) {
		    		lostWorldCount.add(altTextVerification);
		    	}
		    }
		    
		 int actualCountOnLoad = bookList.size();
		 System.out.println(actualCountOnLoad);
		 int countWithperticularName = lostWorldCount.size();
		 System.out.println(countWithperticularName);
		 
		 Assert.assertTrue(countWithperticularName < actualCountOnLoad);
		  Thread.sleep(500);
	}
	@When("User change the language {string} using filter option")
	public void user_change_the_language_using_filter_option(String BookLanguage)throws Throwable  {
		  WebElement frenchBookSearch = driver.findElement(By.xpath(elements.frenchLanguageSearch()));
	               
		  Actions builder = new Actions(driver);
	      builder.moveToElement(frenchBookSearch).click(frenchBookSearch);
	      ScreenshotUtil.captureScreenShot(driver,"French Language clicked");
	   	  builder.perform();
	      Thread.sleep(1000);	          
	}

	@Then("User finds a different count for that particular book search")
	public void user_finds_a_different_count_for_that_particular_book_search() {
		
		ArrayList<String> lostWorldFrenchCount = new ArrayList<String>();
		  List<WebElement> frenchBookList = driver.findElements(By.xpath(elements.searchBookList()));
		  
		    for(WebElement eleBook : frenchBookList) {
		    	String altTextVerification=eleBook.getAttribute("alt");
		    	lostWorldFrenchCount.add(altTextVerification);
		 }
		    
		 int actualCountforFrench = lostWorldFrenchCount.size();
		 System.out.println(actualCountforFrench);
		 ScreenshotUtil.captureScreenShot(driver,"French version Books searched");
		 
		driver.quit();
	}


}
