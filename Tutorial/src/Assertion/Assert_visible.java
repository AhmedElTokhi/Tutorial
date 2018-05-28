package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assert_visible {

	public static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.err.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/css/css_display_visibility.asp");

	}

	@Test
	public void Assert_Visiblility_Attribute() throws Exception {

		// add find element to (target) element
		WebElement target = driver.findElement(By.xpath("//*[@id='imgbox2']"));
		WebElement clickOn = driver.findElement(By.xpath("//*[@id='imgbox2']//button"));

		// Scroll to (target)
		Thread.sleep(2000);

		// When scroll to button not go to correct position But when scroll to
		// (image / image container) go to correct position.
		utils.Scroll.ScrollToElement(driver, target);

		Thread.sleep(1000); // for tester

	//===== assert (target)is visible ======================================== 
		 Assert.assertTrue(target.isDisplayed()); // Valid
// OR
		 Assert.assertTrue(target.isEnabled());   // Valid
// OR
		// Wait until (Target) be visible -using (Target) locator-
		WebDriverWait wait = new WebDriverWait(driver, 60, 250);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='imgbox2']")));  // Valid
// OR		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='imgbox2']"))); // Valid
		
		
		Thread.sleep(1000); // for tester

		System.out.println("button is visible"); // for tester

		// click to hide (target)
		clickOn.click();

		// ===== Assert to invisibility after (Click)======================
		//Assert (target)is NOT visible
		// Assert.assertFalse(target.isDisplayed()); // Valid
// OR
		// Assert.assertFalse(target.isEnabled()); // Not Valid **** Is not work
		// ****
// OR
		// Wait until button to be clickable
		wait.until(ExpectedConditions.invisibilityOf(target)); // Valid

		System.out.println("button is Not visible"); // for tester
		Thread.sleep(1000); // for tester

	}

	@AfterMethod
	public static void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
