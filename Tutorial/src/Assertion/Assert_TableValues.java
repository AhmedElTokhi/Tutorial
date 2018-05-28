package Assertion;

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

public class Assert_TableValues {

	WebDriver driver = new ChromeDriver();

	@Test
	public void GetAndPrint_TableValues() throws Exception {

		// 1) Create the object of the first table.
		WebElement elemTable = driver.findElement(By.xpath("//table[1]"));

		// 2) Get all the Rows of table from this elemTable variable.
		List<WebElement> trlist = elemTable.findElements(By.tagName("tr"));

		// String variable for search keyword
		String searchkey = "Facebook.com";

		// String variable to be used in Assertion
		String Assetwith = null;
		
		//for tester check on console
//		System.out.println("Row number " + trlist.size());
		for (WebElement elemTr : trlist) {

			// Fetch the columns from a particular row (for each row)
			List<WebElement> tdlist = elemTr.findElements(By.xpath("td"));

			//for tester check on console
//			System.out.println("Column size" + tdlist.size());

			for (WebElement w : tdlist) {

				String S = w.getText();
				
				//for tester check on console
//				System.out.println("Current cell Value: " + S);

				if (S.contains(searchkey)) {
					Assetwith = S;
					
					break;
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