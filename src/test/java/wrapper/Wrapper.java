package wrapper;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrapper implements BaseWrapper {

	public static RemoteWebDriver driver;
	public Actions action;

	public void browserLaunch(String browsername, String url) {
		WebDriverManager WebDriverManager = null;
		try {
			switch (browsername.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();

			System.out.println("Browser launched successfully");
		} catch (Exception e) {
			System.out.println("Unable to load the URL" + e);
		}

	}

	// Method used to identify the element in the page
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElement(By.id(locValue));
			case ("link"):
				return driver.findElement(By.linkText(locValue));
			case ("xpath"):
				return driver.findElement(By.xpath(locValue));
			case ("name"):
				return driver.findElement(By.name(locValue));
			case ("class"):
				return driver.findElement(By.className(locValue));
			case ("tag"):
				return driver.findElement(By.tagName(locValue));
			}
		} catch (NoSuchElementException e) {
			System.out.println("Exception occured on locate elements : " + locValue);
		} catch (WebDriverException e) {
			System.out.println("Exception occured on locate elements : " + locValue);

		}
		return null;
	}

	public List<WebElement> locateElements(String locator, String locValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElements(By.id(locValue));
			case ("link"):
				return driver.findElements(By.linkText(locValue));
			case ("xpath"):
				return driver.findElements(By.xpath(locValue));
			case ("name"):
				return driver.findElements(By.name(locValue));
			case ("class"):
				return driver.findElements(By.className(locValue));
			case ("tag"):
				return driver.findElements(By.tagName(locValue));
			}
		} catch (NoSuchElementException e) {
			System.out.println("Exception occured on locate elements : " + locValue);
		} catch (WebDriverException e) {
			System.out.println("Exception occured on locate elements : " + locValue);

		}
		return null;
	}

	public void click(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			System.out.println("Click action performed on element : " + ele);
		} catch (Exception e) {
			System.out.println("Exception occured on element click : " + e);
		}
	}

	public void typeValue(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("Type action performed on element : " + ele);
		} catch (Exception e) {
			System.out.println("Invalid element exception occured on element type");
		}

	}

	public String getTextValue(WebElement ele) {
		String textValue = "";
		try {
			textValue = ele.getText();
			System.out.println("value retrieved for the element : " + textValue);
		} catch (WebDriverException e) {
			System.out.println("Exception occured on get text");
		}
		return textValue;
	}

	public void selectValueByVisibleText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			System.out.println("Element selected successfully" + ele);
		} catch (Exception e) {
			System.out.println("Exception occured on select element");
		}
	}

	public void selectValueByvalue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			System.out.println("Element selected successfully" + ele);
		} catch (Exception e) {
			System.out.println("Exception occured on select element");
		}
	}

	public void pageDownToSpecificElement(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0]. scrollIntoView(false);", ele);
			System.out.println("Page scrolled down successfully to the specific element");

		} catch (Exception e) {
			System.out.println("Exception occured on while scrollling the page to specific element ::"+ ele);
		}
	}

	public String getTitleName() {
		return driver.getTitle();
	}

	public void clickSpecificElementByAction(WebElement ele) {
		action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}

	public void movetoSpecificElementByAction(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

}
