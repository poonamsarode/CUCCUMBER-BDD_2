package vit.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "classpath:features",
		glue = "vit.automation.stepdefs",
		tags = "@ui ",
		plugin =  {"pretty",         // to generate reports
	            "html:target/html/htmlreport.html",
	            "json:target/json/file.json",
	            },
		    monochrome = true,    // this is used for remove the foreign characters 
	        publish=true,
	        dryRun=false          // to tell whether to test run(true) or actual run(false)
	)


public class TestRunner {

}
