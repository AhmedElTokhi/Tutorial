package A1_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriver_With_DefaultValue {

	public WebDriver driver;

//	=== @optional define "default value" in case of not receive value by executer (xml or CMD) ==

	@BeforeMethod
	// Define parameters = method parameter in @parameter
    @Parameters({ "url", "browser" })
	
	public void setup(@Optional("https://www.facebook.com/") String url,@ Optional ("chrome") String browser) {
		System.out.println("@BeforeMethod");
		System.out.println("WebDriver have default value");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if

		(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();	// FireFox_Browser ver. 58.0.2 is compatible with FireFoxDriver "geckodriver" ver. 0.19.1 ----as current setup

		driver.get(url);
	 }

	@Test
	public void Login() {
	// Related to Case 2
//		driver = new ChromeDriver();
//		System.out.println("Case 2: Define (ChromeDriver) instance in Test Method");
	// Related to Case 1 & Case 2 & Case 3
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
