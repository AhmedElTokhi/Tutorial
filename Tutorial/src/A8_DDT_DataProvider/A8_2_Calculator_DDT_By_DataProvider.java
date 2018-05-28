package A8_DDT_DataProvider;

/* Calculator using DDT "Data Driven test" 
 * Using == TestNG (DataProvider)== 
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A8_2_Calculator_DDT_By_DataProvider {

	static WebDriver driver= new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod ()
	public void setup() {
		
		System.out.println("@BeforeMethod");
		driver.get("https://juliemr.github.io/protractor-demo/"); // Use_(get)function_of_new_instance_to_send_URL

	}

	@AfterMethod ()
	public void TearDown() {
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
//OR
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" +z+ "')]")));

	}
//===========================================================================================================
// ::Note:: in case of repeat "TestCase Steps" and ONLY change in data, we have to use Data Driven Test (DDT)
//===========================================================================================================	
//OR ################ Use DataProvider ########################	

	// ==== Create TestNG (DataProvider)===================== .............2- Create TestNG (DataProvider)
	@DataProvider (name= "My data provider")
	public Object[][] dataProvider(){
		String [][] data={
				{"1","+","1","2"},
				{"5","-","3","2"},
				{"3","*","5","15"},
				{"15","/","3","5"}
				};
		return data;
	}
		
	// ==== Fill data using TestNG (DataProvider)============ .............3- link test with (DataProvider)	to be used in data input		
	@Test (dataProvider= "My data provider")
	public void TestCalcParamitarized(String in1,String Op, String in2,String Expec){ //.... 1- Parameterized test method -Define method input parameters-
		Calc(in1, Op, in2);
		assertResult(Expec);	
	}
}
