package A2_TestNG;
/* Write test script using TestNG approach and check report

 ============================================== TestNG Report ==================================================
 *** After run test cases using TestNG you can check execution report that created by TestNG ***
 *** TestNG Report in Directory (Project/Test-Output/index.html), (Project/Test-Output/emailable-report.html)***
 **(Project/Test-Output/testng-results.xml) ***
 ===============================================================================================================
*/

// can convert report timestamp like(11341) using google converter

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A2_3_TestNG_Report {

	public static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.err.println("@BeforeMethod");
		driver = new ChromeDriver();
	}

	@Test
	public static void TestCase1() {
		System.err.println("@test:TestCase1");

	}

	@Test
	public static void TestCase2() {
		System.err.println("@test:TestCase2");

		driver.findElement(By.id("email")).sendKeys("ahmed_ocp1@hotmail.com");
	}


	@AfterMethod
	public static void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
