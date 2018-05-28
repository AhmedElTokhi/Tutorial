package A81_CSV_To_DProvider;

//Calculator using DDT "Data Driven test" from CSV file.

/*The main steps:
 * ==============
 * 1- Get file path.
 * 2- Create CSV reader.
 * -------------------------
 * 3- Create Array String.
 * 4- Read file values via CSV reader and store it in Array String.
 * -------------------------
 * 5- Add list of Array String values to 2D array that it can match the DataProvider return type*/

import java.io.FileReader;
import java.io.IOException;
import java.util.List; 
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

import au.com.bytecode.opencsv.CSVReader;

public class Calculator_DDT_ReadCsv_1 {

	static WebDriver driver; // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.get("https://juliemr.github.io/protractor-demo/"); // Use_(get)function_of_new_instance_to_send_URL

	}

	@AfterMethod(alwaysRun = true)
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
		// OR
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" +z+ "')]")));

	}

	@SuppressWarnings("resource")
	@DataProvider(name = "CalaCSVData")

	public Object[][] dataProvider() throws IOException {
		
		//1&2- Create CSV file reader that use file path.
		CSVReader reader = new CSVReader(new FileReader("./ReadFrom/CalcInput.csv"));
		
		//3- Create list of Array String.
		//4- Read file values via CSV reader and store it in list of Array String.
		List<String[]> list = reader.readAll();
		
		//5.1- Create 2D array with length = list of array length.
		String[][] array = new String[list.size()][];

		//5.2- Add list of Array String values to 2D array that it can match the DataProvider return type.
		list.toArray(array);
		
		return array;
		}

	// ==== Fill data using TestNG (DataProvider)============
	@Test(dataProvider = "CalaCSVData")
	public void TestCalcParamitarized(String in1, String Op, String in2, String Expec) {
		Calc(in1, Op, in2);
		assertResult(Expec);

	}

}
