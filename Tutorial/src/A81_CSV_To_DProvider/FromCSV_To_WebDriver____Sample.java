package A81_CSV_To_DProvider;

//Calculator using DDT "Data Driven test" from CSV file.

/*The Main Steps:
* ===============
* 1- Get file path.
* 2- Create CSV reader.
* -------------------------
* 3- Create Array String.
* 4- Read file values via CSV reader and store it in Array String.*/

import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class FromCSV_To_WebDriver____Sample {
	WebDriver driver;

	//1- Get file path
	private static final String FILE_PATH = "./ReadFrom/SearchKeyword.csv";

	@BeforeMethod
	public void Setup() {
		System.out.println(":@BeforeMethod");

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@SuppressWarnings("resource")
	@Test
	public void Read_CSV_File() throws Exception {
		System.out.println(":@Test");

		//2- Create "Reader" object from CSVReader
		CSVReader reader = new CSVReader(new FileReader(FILE_PATH));

		//3- Create Array String 
		//nextLine[] is an array to read rows from file.

		// ::Note:: To escape (1st Row = row 0) as a header, we can do as following.
		String[] cell = reader.readNext();

		//4- Read file values via CSV reader and store it in Array String.
		while ((cell = reader.readNext()) != null) {
			//Pass current value to variable (SearchBy)
			String SearchBy = cell[0];

			//use (SearchBy) value (sendkeys) value as following
			driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(SearchBy);
			driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(Keys.ENTER);
			System.out.println("Now we search with keyword: " + SearchBy);

			driver.findElement(By.xpath("//*[@id='lst-ib']")).clear();
			System.out.println("keyword cleared");

// 			// For loop to print array values
//			 for (int i = 0; i < nextLine.length; i++) {
//			
//			 System.out.println("Value" + ": [" + nextLine[i] + "]");
//			 }
		}
	}

	@AfterMethod
	public void TearDown() {
		System.out.println(":@AfterMethod");
		driver.quit();

	}
}