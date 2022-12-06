package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/resources/Features/GoogleSearch.feature", 
		glue= {"StepDefinitions"},

		plugin = {"pretty", 
		    
  		    "junit:target/JUnitReports/report.xml",
   			"json:target/JSONReports/report.json",
   			"html:target/HtmlReports"},
		strict = true
		
)

public class TestRunner {

}
