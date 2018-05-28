package A82_CSV_To_DProvider_MMostafa;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Calc_POM_SelfCSVDProvider {

	public WebDriver driver;// removing the "static" modifier as it causes threads interruption (http://forumsqa.com/question/selenium-testng-parallel-execution/)

	@BeforeMethod
	@Parameters({ "url", "browser" })
	public void setUp(String url, String browser) {
		System.out.println("@BeforeMethod");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(url);// "https://juliemr.github.io/protractor-demo/"
	}

	// ====================================
	@DataProvider(name = "csvDataProvider")
	public Object[][] csvDataProvider() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("./ReadFrom/numbers.csv"));
		// creating an object from the scanner file reader
		String line = null;
		String data[] = null;
		ArrayList<Object> paramList = new ArrayList<Object>();
		String[][] parameters;

		while (scanner.hasNextLine())
		// a conditional procedure that will be executed only if the file has a next non-empty line
		{
			line = scanner.nextLine();// Read the file next line & put it into a string
			// System.out.println(line);//this line is useful for as it prints every retrieved line for the file
			data = line.split(",");
			// Convert the line from being a string into an array of strings(String[]) which can be detected by the "," character
			paramList.add(data);
			// Add the retrieved array of strings(String[]) as an element (or Object) into an array list of objects (ArrayList<Object>)
		}
		// by the end of this conditional statement, all the lines will be added as objects into the (ArrayList<Object>)
		parameters = paramList.toArray(new String[paramList.size()][]);
		// Now we need to cast the (ArrayList<Object>) to a multi dimensional array of Strings (String [][]) so that it can match the DataProvider returntype
		scanner.close(); // Closes the scanner (The file reader object)
		return parameters;

	}

	// ====================================
	@Test(dataProvider = "csvDataProvider")
	public void testCalculatorParametrized(String in1, String in2, String oper, String expected) {
		CalculatorProBusiness calcObj = new CalculatorProBusiness(driver);
		System.out.println("Test: testCalculatorParametrized");
		calcObj.mathOperation(in1, in2, oper);
		calcObj.waitCalculate(expected);
	}

	// ==============================
	@AfterMethod
	public void tearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}

}
