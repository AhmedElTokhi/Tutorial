package A1_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Simple_WebDriver {

	// Define driver and create browser instance (Chrome)in class level to call it in all methods.
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		System.out.println("Use chromedriver in project directory using 'System.setProperty'");

	}

	@Test
	public void Login() {

		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("ahmed_ocp1@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("1020304050");

		driver.findElement(By.id("loginbutton")).click();

		// =========== Assert after in home page ==============
		Boolean xpathv = driver.findElement(By.xpath("//html[@id='facebook']//div[@id='u_0_a']//a[@title='Profile']//span[@class='_1vp5']")).isDisplayed();

		if (xpathv == true) // compare message content
			System.out.println("Test case is pass - user successfully login");
		else {
			System.out.println("Test case is fail - user can not login");
		}
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
