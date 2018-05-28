package ScreenShot_for_Web;

// Calculator using DDT "Data Driven test" 

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculator_With_SpecificElement_ScreenCapture {

	static WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void setup() {
		System.err.println("@BeforeMethod");

		driver.get("https://juliemr.github.io/protractor-demo/");
	}

	@AfterMethod
	public void TearDown() throws IOException {
		System.out.println("@AfterMethod");
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
	@Test()
	public void Calc() throws Exception {
		Calc("2", "+", "3");
		assertResult("5");
		
		By Resulttable = By.xpath("//table");
		long timestamp = System.currentTimeMillis();
		
		utils.ScreenCapture.getPartScreenShot(driver, Resulttable, "./Screenshots/Element_Image"+timestamp+".png");
	}

}
