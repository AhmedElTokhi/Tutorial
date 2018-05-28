package A82_CSV_To_DProvider_MMostafa;

import java.util.List;
import java.io.FileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import au.com.bytecode.opencsv.CSVReader;

public class Calc_POM_OpenCSVDProvider {

public  WebDriver driver;//removing the "static" modifier as it causes threads interruption (http://forumsqa.com/question/selenium-testng-parallel-execution/)
	
@BeforeMethod
@Parameters({"url" , "browser"})
	public void setUp(String url , String browser)
		{
			System.out.println("@BeforeMethod");
				if (browser.equalsIgnoreCase("chrome")){
				
					driver = new ChromeDriver();	
				}else if (browser.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
			}
			driver.get(url);//"https://juliemr.github.io/protractor-demo/"
		}

//====================================
@SuppressWarnings("resource")
@DataProvider(name = "csvDataProvider")
//reading the data from a CSV file based on the "OpenCSV" library that must be imported to the project
	public Object[][] csvFileReader() throws Exception{//(https://stackoverflow.com/questions/35178375/showing-java-lang-nullpointerexception-at-org-testng-internal-methodinvocationhe)
		CSVReader readunamepass= new CSVReader(new FileReader("./readFrom/numbers.csv"));
		List<String[]> list = readunamepass.readAll();
		String[][] array = new String[list.size()][];

//=== Add list data to 2D Array ===
		list.toArray(array);
	//OR	
//		for(int i=0;i<list.size();i++)
//		{
//		array[i] = list.get(i);
//			}
		return array;
		}

//====================================
@Test (dataProvider = "csvDataProvider")
	public void testCalculatorParametrized(String in1, String in2 , String oper , String expected)
			{
				CalculatorProBusiness calcObj = new CalculatorProBusiness(driver);
				System.out.println("Test: testCalculatorParametrized");
				calcObj.mathOperation(in1 , in2 , oper);
				calcObj.waitCalculate(expected);
			}

//==============================
@AfterMethod
	public void tearDown()
		{
			System.out.println("@AfterMethod");
			driver.quit();
		}


}
