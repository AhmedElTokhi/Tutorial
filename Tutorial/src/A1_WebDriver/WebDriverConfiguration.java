package A1_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverConfiguration {

	public WebDriver driver;
		
// == WebDriver.exe path in system property ==
	
	/* 1- rename ChromeDriver in path (C:\WebDriver)
	 * 2- Set property for "WebDriver" in new directory -inside project-, 
	 * using  System.setProperty("webdriver.gecko.driver", driverPath);
	 * Instead of find driver.exe directory in windows (system environment)-> path values.
	 * ::Note:: per browser we have to edit WebDrive.exe name in (System.setProperty) 
	 */

	
	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		System.out.println("Use chromedriver in project directory using 'System.setProperty'");

		//try to sun script after commit next line and without commit 
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
		
			driver = new ChromeDriver();

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
