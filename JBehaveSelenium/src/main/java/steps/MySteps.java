package steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

public class MySteps extends Steps {
	
	private static WebDriver driver = null;
	
	@Given("the browser is open")
	public void openBrowser () {
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
	}
	
	@Given("the page $site is displayed")
	public void navigateToPage (String site) {
		
		driver.get(site);
		
	}
	
	@When("I search for $query")
	public void clickOn (String query) {
		
		WebElement cookieOption = driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div"));
		WebElement searchField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
		cookieOption.click();
		searchField.sendKeys(query);
		searchField.sendKeys(" ");
		searchButton.click();
	}
	
	@Then("the content $content is displayed")
	public void checkContent (String content) {
		
		Assert.assertEquals(content,driver.findElement(By.xpath("//*[contains(text(),'"+content+"')]")).getText());
		
	}
	
	@AfterStory
	public void closeSession() {
		driver.quit();
	}
	
}