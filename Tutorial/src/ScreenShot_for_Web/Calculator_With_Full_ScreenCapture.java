package ScreenShot_for_Web;

// Calculator using DDT "Data Driven test" 

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculator_With_Full_ScreenCapture {

	static WebDriver driver= new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine
	
	@BeforeMethod
	public void setup() {
		System.err.println("@BeforeMethod");
		
		driver.get("https://juliemr.github.io/protractor-demo/");
	}
	
	
	@AfterMethod
	
// ==================== define (result) from (ITestResult)to used by testGN to store test result in it, to be used in next action ============
	public void TearDown(ITestResult result) throws IOException {
		System.out.println("@AfterMethod");

// ====================here add time stamp=================================
		long TimeStamp = System.currentTimeMillis();
// ====================here add take Screen capture in case of============= 

/* ***** use custom package (utils)to be able to execute ****
 * 
 * ::Note:: we can take screenshot for part of screen element (yyyy), by using find element of find element
			find element(by.xxxx).find element(by.yyyy)
*/
		
		if(result.isSuccess())
			utils.ScreenCapture.getFullScreenShot(driver, "./ScreenShoot/myImage"+TimeStamp+".png");
		else
			utils.ScreenCapture.getFullScreenShot(driver, "./ScreenShoot/MyFailImage"+TimeStamp+".png");

/*************need to read in (TestNG Listeners)***************
 * (http://testng.org/doc/documentation-main.html#testng-listeners)*/
		
		
		driver.quit();
	}

	public void Calc(String x, String Opcode, String y) {
		driver.findElement(By.xpath("//input[1]")).clear();
		driver.findElement(By.xpath("//input[1]")).sendKeys(x);

		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys(y);
		
		Select operator = new Select(driver.findElement(By.xpath("//select")));
		operator.selectByVisibleText(Opcode);

		driver.findElement(By.id("gobutton")).click();

	}

	public void assertResult(String z) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 250);
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), z));
		}
	
// ==== Fill data using TestNG (DataProvider)============		
	@Test () 
	public void Calc()throws Exception {
		Calc("1","+","1");
		assertResult("2");
		
	}
	
}
