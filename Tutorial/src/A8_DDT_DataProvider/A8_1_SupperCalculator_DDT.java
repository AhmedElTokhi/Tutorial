package A8_DDT_DataProvider;

//login to (https://juliemr.github.io/protractor-demo/) and do 4 math operation (+, -, *, /)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A8_1_SupperCalculator_DDT {

	static WebDriver driver; // Create_instance_from_WebDriver_to_current_machine

	// Locator
	By Textinput1 = By.xpath("//input[1]");
	By TextInput2 = By.xpath("//input[2]");
	By CalcResult = By.xpath("//h2[@class='ng-binding']");
	By TableResult = By.xpath("//tr[@class='ng-scope']/td[3]");

	// Business
	public void Calculator(String No1, String Operator, String No2) {

		// Enter No.1
		driver.findElement(Textinput1).clear();
		driver.findElement(Textinput1).sendKeys(No1);

		// Select Operator
		Select operator = new Select(driver.findElement(By.xpath("//select")));
		operator.selectByVisibleText(Operator);

		// Enter No.2
		driver.findElement(TextInput2).clear();
		driver.findElement(TextInput2).sendKeys(No2);

		// Click go button
		driver.findElement(By.id("gobutton")).click();
	}

	public void AssertCalcResult(String ExpResult) {	// Create expected result type is String to be able to hold (float, + value, -Value)
		
		WebDriverWait wait = new WebDriverWait(driver, 60, 250);
//		wait.until(ExpectedConditions.textToBe(CalcResult, ExpResult));
	//OR
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" +ExpResult+ "')]")));				
	}

	public void assertTableResult(String ExpeResult) {    // Create expected result type is String to be able to hold (float, + value, -Value)

		String CurrResult = driver.findElement(TableResult).getText();
		Assert.assertTrue(CurrResult.contains(ExpeResult));
	}

	
//	// ========= - operator ====================
////	@Test
//	public void minus_TestCase() throws Exception {
//
//		Calculator("10", "-", "3");
//
//		AssertCalcResult("7");
//
//		assertTableResult("7");
//
//		// For Tester to see result
//		Thread.sleep(1000);
//	}
//
//	// ========= / operator ====================
////	@Test
//	public void division_TestCase() throws Exception {
//		Calculator("5", "/", "2");
//
//		AssertCalcResult("2.5");
//
//		assertTableResult("2.5");
//
//		// For Tester to see result
//		Thread.sleep(1000);
//	}
//
//	// ========= * operator ====================
////	@Test
//	public void Multiply_TestCase() throws Exception {
//
//		Calculator("2", "*", "5");
//
//		AssertCalcResult("10");
//
//		assertTableResult("10");
//
//		// For Tester to see result
//		Thread.sleep(1000);
//	}
//
//	// ========= + operator ====================
////	@Test
//	public void Plus_TestCase() throws Exception {
//		Calculator("2", "+", "3");
//
//		AssertCalcResult("5");
//
//		assertTableResult("5");
//
//		// For Tester to see result
//		Thread.sleep(1000);
//	}

//===========================================================================================================
// ::Note:: in case of repeat "TestCase Steps" and ONLY change in data, we have to use Data Driven Test (DDT)
//===========================================================================================================	
//OR ################ Use DataProvider ########################
	
	// ==== Create TestNG (DataProvider)===================== .............2- Create TestNG (DataProvider)
	@DataProvider (name= "Provider1")
	public Object [][]dataProvider(){
		String [][] data={
				{"5", "+","5","10"},
				{"10","*","2","20"},
				{"15","-","5","10"},
				{"10", "/","2","5"}
		};	
		return data;
	}
	
	// ==== Fill data using TestNG (DataProvider)============ .............3- link test with (DataProvider)	using (Provider name)to be used in data input
	@Test (dataProvider ="Provider1")
	public void Calculator_TestCase(String no1, String Oper, String no2, String AsserValue) throws Exception{   //.... 1- Parameterized test method -Define method input parameters-
		Calculator(no1, Oper, no2);
		
		AssertCalcResult(AsserValue);
		
		assertTableResult(AsserValue);
		
		Thread.sleep(1000);
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://juliemr.github.io/protractor-demo/"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
