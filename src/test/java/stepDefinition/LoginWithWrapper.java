package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import wrapper.Wrapper;

public class LoginWithWrapper extends Wrapper {

	@Given("Launch the url and Navigate to login Page")
	public void launchUrl() {
		browserLaunch("FireFox", "https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		movetoSpecificElementByAction(locateElement("xpath", "(//span[@class='title'])[32]"));
		click(locateElement("xpath", "(//span[@class='title'])[33]"));

	}

	@Then("Enter valid Username as {string}")
	public void enterUserName(String value) {
		// driver.findElement(By.id("input-email")).sendKeys(value);
		typeValue(locateElement("id", "input-email"), value);
	}

	@Then("Enter Password as {string}")
	public void enterPassword(String passCode) {
		typeValue(locateElement("id", "input-password"), passCode);

	}

	@And("Select login button")
	public void selectLogin() {
		click(locateElement("xpath", "//input[@class='btn btn-primary']"));
	}

}
