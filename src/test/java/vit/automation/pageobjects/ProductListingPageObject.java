package vit.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPageObject {

	private static final Logger logger = LogManager.getLogger(ProductListingPageObject.class);

	// sec1 declare a driver object
	private WebDriver driver;
	private WebDriverWait webDriverWait;

	// Sec2 parametrize the constructor
	public ProductListingPageObject(WebDriver driver, WebDriverWait webDriverWait) {
		this.driver = driver;
		this.webDriverWait = webDriverWait;

	}

	// sec3 Define the locaters
	// private By searchBoxElement = By.id("twotabsearchtextbox");

	// sec4 Write Business Methods (method to be exposed ) agent
	
	  public void ValidatesearchResult(String prodName ) {
		 logger.info("Waiting for page title to be contain -> " + prodName);
		 webDriverWait.until(ExpectedConditions.titleIs("Amezon.in : "+prodName+""));
		//Assertion for Page Title
		 Assert.assertEquals("Page Title validation","Amazon.in : "+prodName+"", driver.getTitle());
		 logger.info("Assertion passed for validation of Search Result with product name as -> " + prodName);

	  }

}
















