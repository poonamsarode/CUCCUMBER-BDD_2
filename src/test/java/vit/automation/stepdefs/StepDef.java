package vit.automation.stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vit.automation.pageobjects.LandingPageObjects;
import vit.automation.pageobjects.ProductDescPageObject;
import vit.automation.pageobjects.ProductListingPageObject;

public class StepDef {
	
    private static final Logger logger = LogManager.getLogger(StepDef.class);

	    Scenario scn;
	    WebDriver driver;
	    String base_url = "https://amazon.in";
	    int implicit_wait_timeout_in_sec = 20;
	    WebDriverWait webDriverWait;
	    
	    LandingPageObjects landingPageObjects;
	    ProductListingPageObject productListingPageObject;
	    ProductDescPageObject productDescPageObject;
	    
  @Before
  public void setup(Scenario scn)
	    {
	        this.scn = scn;
	    	driver = new ChromeDriver();
	    	webDriverWait = new WebDriverWait(driver,20);
	        logger.info("Browser got set");
	        driver.manage().window().maximize();
	        logger.info("Browser got maximized");
	        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	        logger.info("Browser Implicit timeout set to -> " +  implicit_wait_timeout_in_sec);
	        scn.log("Browser got invoked");
	        
	        // Initialize class Objects
	        landingPageObjects = new LandingPageObjects(driver, webDriverWait);
	        productListingPageObject = new ProductListingPageObject(driver, webDriverWait);
	        productDescPageObject = new ProductDescPageObject(driver, webDriverWait);
	        
	    }
  
  @After 
  public void tearDown()
  {
	  driver.quit();
	  logger.info("Browser got closed");
	  scn.log("Browser got closed");
  }
	

@Given("User navigated to the landing page of application")
public void user_navigated_to_the_landing_page_of_application() { 
	   landingPageObjects.validateUserIsOnLandingPage(base_url);
       scn.log("User navigated to the landing page of application");

}
@When("User Search for product {string}")
public void user_search_for_product(String productName) {
	 landingPageObjects.searchProduct(productName);
     scn.log("User Searched for product");
	   
}

@Then("Search Result page is displayed {string}")
public void search_result_page_is_displayed(String prodName) {

	productListingPageObject.ValidatesearchResult(prodName);
     scn.log("Search Result page is displayed");
   
}


@When("User click on any product")
public void user_click_on_any_product() {
	
	productDescPageObject.clickOnAnyProd();

    scn.log("User click on any product");
   
}

@Then("Product Description is displayed in new tab")
public void product_description_is_displayed_in_new_tab() {
  
	 Set<String> handles = driver.getWindowHandles();           // get all the open windows
     Iterator<String> it = handles.iterator();                  // get the iterator to iterate the elements in set
     String original = it.next();                               //gives the parent window id
     String prodDescp = it.next();                              //gives the child window id
     driver.switchTo().window(prodDescp);                       // switch to product Descp

     WebElement productTitle = driver.findElement(By.id("productTitle"));
     Assert.assertEquals("Product Title",true,productTitle.isDisplayed());

     WebElement addToCartButton = driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
     Assert.assertEquals("Product Title",true,addToCartButton.isDisplayed());
     
     driver.switchTo().window(original);
     scn.log("Product Description is displayed in new tab");
     
}
















}
