package A3_Table;

/* ==================================================================================
 * 1- Need to manage this class for reusable and put it in (utils) package
 * 2- Need to do same sample for (Div table)
 * 	Div table
	=============
	https://html-cleaner.com/features/replace-html-table-tags-with-divs/
	http://divtable.com/table-styler/
	https://stackoverflow.com/questions/43813416/div-table-responsive-header-repeats
 * ==================================================================================*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A3_5_4_Div_Assert_TableValues {

	WebDriver driver = new ChromeDriver();

	@Test
	public void GetAndPrint_TableValues() throws Exception {
		System.out.println("@Test");
		
// 1) Create the object of the first table.
		WebElement elemTable = driver.findElement(By.xpath("//*[@id='pagewrap']//div[1]/article/div[3]/div"));

// 2) Get all the Rows of table from this elemTable variable.
		List<WebElement> Rowslist = elemTable.findElements(By.tagName("div"));
		
// 3) To get the data from table we need to traverse the Rows and Columns of the table

		// String variable for search keyword
		String searchkey= "Pool cleaning";
		
		// String variable to be used in Assertion
		String Assetwith=null;
		for (WebElement elemTr : Rowslist) {

			// Fetch the columns from a particular row (for each row)
			List<WebElement> columnlist = elemTr.findElements(By.xpath("div"));
		

			//if column list (columnlist) have value
			if (columnlist.size() > 0) {
				
				// For each row accumulated store columns value in (strRowData) and print it in console.
				for (WebElement w : columnlist) {
						
					// Save (w)text value in string
					String S = w.getText();
					
					// If current variable(S)text = variable(searchkey)value, store (S) value in variable(Assetwith). 
					if (S.contains(searchkey)) {
						Assetwith=S;
					}
				}
			} 

		}
		// Assert for table contain (Search keyword)
		Assert.assertTrue(Assetwith.contains(searchkey));
		System.err.println("list contain value: " +searchkey);
	}

	@BeforeMethod
	public void Setup() {
		System.out.println("@BeforeMethod");
		driver.get("https://html-cleaner.com/features/replace-html-table-tags-with-divs/");
	}

	@AfterMethod
	public void teardown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
