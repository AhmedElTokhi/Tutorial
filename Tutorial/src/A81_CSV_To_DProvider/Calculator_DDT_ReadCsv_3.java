package A81_CSV_To_DProvider;

//Calculator using DDT "Data Driven test" from CSV file.

/*The Main Steps:
* ===============
* 1- Get file path.
* 2- Create CSV reader.
* -------------------------
* 3- Create Array String.
* 4- Read file values via CSV reader and store it in Array String.
* -------------------------
* 5- Add list of Array String values to 2D array that it can match the DataProvider return type.*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

public class Calculator_DDT_ReadCsv_3 {

	static WebDriver driver; 

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.get("https://juliemr.github.io/protractor-demo/"); 

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


	@DataProvider(name = "CalaCSVData")

	public Object[][] dataProvider() throws IOException {

		// 1&2- Create an object Scanner file reader that use file path.
		Scanner scanner = new Scanner(new File("./ReadFrom/CalcInput.csv"));
		
		String line = null;
		String []data = null;
		//3- Create list of Array String.
		ArrayList<Object> paramList = new ArrayList<Object>();
		
		//5- Create 2D array String.
		String[][] parameters;

	//4- Read file values via Scanner and store it in list of Array String.
		// a conditional procedure that will be executed only if the file has a next non-empty line
		while (scanner.hasNextLine()){

			//4.1- Read the file next line & put it into a string
			line = scanner.nextLine();
		
			// System.out.println(line);//this line is useful for as it prints every retrieved line for the file
			
			//4.2- Convert the line from being a string into an array of strings(String[]) which can be detected by the "," character
			data = line.split(",");

			//4.3- Add the retrieved array of strings(String[]) as an element (or Object) into an array list of objects (ArrayList<Object>)
			paramList.add(data);
		}
		// by the end of this conditional statement, all the lines will be added as objects into the (ArrayList<Object>)
		
		// 5- Add list of Array String values to 2D array.
		// Now we need to cast the (ArrayList<Object>) to a Multi-dimensional array of Strings (String [][]) so that it can match the DataProvider return type
		parameters = paramList.toArray(new String[paramList.size()][]);
		
		scanner.close(); // Closes the scanner (The file reader object)
		return parameters;
	}
	
	// ==== Fill data using TestNG (DataProvider)============
	@Test(dataProvider = "CalaCSVData")
	public void TestCalcParamitarized(String in1, String Op, String in2, String Expec) {
		Calc(in1, Op, in2);
		assertResult(Expec);

	}

}
