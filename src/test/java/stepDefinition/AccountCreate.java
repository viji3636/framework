package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountCreate {
  
  public RemoteWebDriver driver;
  
    @Given("Launch the url and Navigate to Register page")  
	public void launchUrl() {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    	
    	Actions act=new Actions(driver);
    	act.moveToElement(driver.findElement(By.xpath("(//span[@class='title'])[32]"))).build().perform();
    }
    @Then ("Click the Register button")
    public void registerButton() {
    	driver.findElement(By.xpath("(//span[@class='title'])[34]")).click();
    	
}
    @Then ("Enter the First Name")
    public void firstName() {
    	driver.findElement(By.id("input-firstname")).sendKeys("viji");
    }
    @And("Enter the Last Name")
    public void lastName() {
    	driver.findElement(By.id("input-lastname")).sendKeys("vg");
    }
    @Then("Enter the E Mail")
    public void eMail() {
    	driver.findElement(By.id("input-email")).sendKeys("asd3655@gmail.com");
    }
    @And("Enter the Telephone number")
    public void telephone() {
    	driver.findElement(By.id("input-telephone")).sendKeys("234567890");
    }
    @And("Enter the Password")
    public void passWord() {
    driver.findElement(By.id("input-password")).sendKeys("987654321");
    }
    @Then("Enter the password confirm")
    public void passWordConfirm() {
    	driver.findElement(By.id("input-confirm")).sendKeys("987654321");
    }
    @And("Click the Subscribe No")
    public void subscribe() {
    	driver.findElement(By.className("custom-control-label")).click();
    }
    @And("CLICK the Agree to Privacy Policy")
    public void privacyPolicy() {
    	driver.findElement(By.xpath("(//label[@class='custom-control-label'])[3]")).click();
    	
    }
    @Then("Click the Continue")
    public void continu() {
    	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
    }
    
         
}