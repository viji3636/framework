package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public RemoteWebDriver driver;
	
	@Given("Launch the url and Navigate to login Page")
	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//span[@class='title'])[32]"))).build().perform();

		driver.findElement(By.xpath("(//span[@class='title'])[33]")).click();

	}
	
	@Then("Enter valid Username")
	public void enterUserName() {
		driver.findElement(By.id("input-email")).sendKeys("sampletest001@gmail.com");
	}
	
	@Then("Enter valid Password")
	public void enterPassword() {
		driver.findElement(By.id("input-password")).sendKeys("Qwerty@0000");
	}
	
	@And("Select login button")
	public void selectLogin() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	
	}
	

	@Then("Enter invalid Password")
	public void enterinValidPassword() {
		driver.findElement(By.id("input-password")).sendKeys("sdasdasd@0000");
	}
	@Then("Validate login is success")
	public void validateLogin() {
		Boolean value = driver.findElement(By.xpath("//div[@id='content']/../aside//a[2]")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Then("Validate proper error message is getting displayed or not")
	public void validateErroMessage() {
		
		String actualerrorMessage =driver.findElement(By.xpath("//div[contains(@class,\"alert alert-danger\")]")).getText();
		String expectedMessage = "123123123Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedMessage, actualerrorMessage);
		
	}

}
