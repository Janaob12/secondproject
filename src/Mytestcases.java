import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytestcases {

	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://www.saucedemo.com/";
	String TheUserName = "standard_user";
	String TheUserPassword = "secret_sauce";

	@BeforeTest
	public void MySetup() {
		driver.get(theWebsite);

		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void login() {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		UserNameInput.sendKeys(TheUserName);
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys(TheUserPassword);

		WebElement LoginButton = driver.findElement(By.id("login-button"));
		LoginButton.click();

	}

	@Test(priority = 2)

	public void AddItemToTheCart() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i =0 ; i <AddToCartButtons.size();i++) {
			AddToCartButtons.get(i).click();

		}
	}

	@AfterTest

	public void AfterTesting() {
		driver.findElement(By.id("id=\"add-to-cart-sauce-labs-backpack\"")).click();
	}

}
