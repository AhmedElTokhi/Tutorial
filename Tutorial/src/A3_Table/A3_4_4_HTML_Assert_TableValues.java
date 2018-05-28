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

public class A3_4_4_HTML_Assert_TableValues {

	WebDriver driver = new ChromeDriver();

	@Test
	public void GetAndPrint_TableValues() throws Exception {

// 1) Create the object of the first table.
		WebElement elemTable = driver.findElement(By.xpath("//table[1]"));

// 2) Get all the Rows of table from this elemTable variable.
		List<WebElement> trlist = elemTable.findElements(By.tagName("tr"));
		
// 3) To get the data from table we need to traverse the Rows and Columns of the table

		// String variable for search keyword
		String searchkey = "Voldemort[25]";

		// String variable to be used in Assertion
		String Assetwith = null;
		for (WebElement elemTr : trlist) {

			// Fetch the columns from a particular row (for each row)
			List<WebElement> tdlist = elemTr.findElements(By.xpath("td"));

			// if column list (tdlist) have value
			if (tdlist.size() > 0) {

				// For each row accumulated store columns value in (strRowData)and print it in console.
				for (WebElement w : tdlist) {

					// Save (w)text value in string
					String S = w.getText();

					// If current variable(S)text = variable(searchkey)value,store (S) value in variable(Assetwith). 
					if (S.contains(searchkey)) {
						Assetwith = S;
					}
				}
			}
		}
		// Assert for table contain (Search keyword)
		Assert.assertTrue(Assetwith.contains(searchkey));
		System.err.println("list contain value: " + searchkey);
	}

	@BeforeMethod
	public void Setup() {
		System.out.println("@BeforeMethod");
		driver.get("https://en.wikipedia.org/wiki/Programming_languages_used_in_most_popular_websites");
	}

	@AfterMethod
	public void teardown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
