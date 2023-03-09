package vit.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPageObjects {
	
    private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
    
    //sec1 declare a driver object 
    private WebDriver driver ;
    private WebDriverWait webDriverWait;
	
	//Sec2 parametrize the constructor 
    public LandingPageObjects( WebDriver driver,WebDriverWait webDriverWait) {
   	this.driver = driver; 
   	this.webDriverWait = webDriverWait;
   	 
    }

	//sec3 Define the locaters 
    private By searchBoxElement = By.id("twotabsearchtextbox");
	private By searchButtonElement =(By.xpath( "//input[@value='Go']"));                               
     
     //sec4 Write Business Methods (method to be exposed ) agent 
     public void searchProduct(String prodName) {
    	 
     webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
 	 logger.info("Waiting for  webelement -> elementSearchBox to be clickeble");
     driver.findElement(searchBoxElement).sendKeys(prodName);
     logger.info("sending keys into webelement -> searchBoxElement");
     driver.findElement(searchButtonElement).click();
     logger.info("clicking on the search button");
 	 
     }
     
  
     public void validateUserIsOnLandingPage(String base_url)
     {
        driver.get(base_url);
	    logger.info("Browser got invoked with URL as -> " + base_url);
        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
	    logger.info("Assertion for page title validation is passed with expected as -> " + expected + " and actual as -> " + actual);
     
    	 
     }
     
}