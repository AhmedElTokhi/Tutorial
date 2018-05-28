package A3_Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A3_5_1_Div_TableElement____Dynamic_Xpath {

	WebDriver driver;

	By DivTable = By.xpath("//*[@id='pagewrap']//div[3]/h4[2]");

	@BeforeMethod
	public void Setup() {
		System.out.println(":@BeforeMethod");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html-cleaner.com/features/replace-html-table-tags-with-divs/");
	}

	@Test
	public void TableElement() throws Exception {
		System.out.println(":@Test");

		WebElement table = driver.findElement(DivTable);

		utils.Scroll.ScrollToElement(driver, table);

// == Simple Find table element ===================================
		String valus = null;
		valus = driver.findElement(By.xpath("//*[@id='pagewrap']//div[1]/article/div[3]//div[1]/div[2]/div[1]/div[1]")).getText();
		System.out.println("The selected value 1 is :" + valus);

// == Pass dynamic (row and column) value throw testing ===========
		String sRow = "3";

		String sCol = "3";

		String X = driver.findElement(By.xpath("//*[@id='pagewrap']//div[1]/article/div[3]//div[1]/div[2]/div[" + sRow + "]/div[" + sCol + "]")).getText();
		System.out.println("\n The selected value 2 is :" + X);

// == When know header value only and need to print its column value====
		String THeaderValue = "Expenses";

		// First loop will find the 'ClOCK TWER HOTEL' in the last column
		for (int i = 1; i <= 3; i++) {
			String sColValue= null;
			
			sColValue = driver.findElement(By.xpath("//*[@id='pagewrap']/div/div[1]/article/div[3]/div/div[1]/div["+i+"]")).getText();
					if (sColValue.equalsIgnoreCase(THeaderValue)) {

				// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
					System.err.println("\n The column " + sColValue+" Is :" );
					
				for (int j = 01; j <= 3; j++) {
					String sRowValue = driver.findElement(By.xpath("//*[@id='pagewrap']/div/div[1]/article/div[3]/div/div[2]/div["+j+"]/div["+i+"]")).getText();
					
					System.out.println("\n The Row Value: " + sRowValue);
				}
				break;
			}
		}
	}

	@AfterMethod
	public void TearDown() {
		System.out.println(":@AfterMethod");

		driver.quit();

	}
}
