package StepDefinitions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	
	WebDriver driver = null;

	@Given("browser has been opened")
	public void browser_has_been_opened() { 
		
		System.out.println("Browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	//	driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		
		System.out.println("User is on google page");
		driver.navigate().to("https://google.com");
			
	}

	@When("user enters text in search box")
	public void user_enters_text_in_search_box() throws InterruptedException {
		System.out.println("User enters text in search box");	
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(2000);
		
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {  
		System.out.println("User hits enter");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() { 
		System.out.println("User is navigated to search results");
		driver.close();
		driver.quit();
		
	}
	
}
