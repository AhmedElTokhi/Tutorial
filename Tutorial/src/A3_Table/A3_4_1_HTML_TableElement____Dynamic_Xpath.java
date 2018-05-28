package A3_Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A3_4_1_HTML_TableElement____Dynamic_Xpath {
	WebDriver driver = new ChromeDriver();
	@BeforeMethod
	public void Setup() {
		System.out.println("@BeforeMethod");
		driver.get("http://toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/");
	}
//http://toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/
	
	@Test
	public void HTML_Table () throws InterruptedException{
		
// == Simple Find table element ===================================
		String x=null;
		x=driver.findElement(By.xpath("//*[@id='post-2924']/div[1]//div[1]//table/tbody/tr[2]/td[1]")).getText(); 
		System.out.print("The selected value 1 is :"+x);
		
		
// == Pass dynamic (row and column) value throw testing ===========
		String sRow = "2";
		 
		String sCol = "1";
		 
		String y=driver.findElement(By.xpath("//*[@id='post-2924']/div[1]//div[1]//table/tbody/tr["+sRow+"]/td["+sCol+"]")).getText();
		
		System.out.println("\n The selected value 2 is :"+y);
		

// == When know header value only and need to print its column value====		
		String THeaderValue = "Licensing";
		 
		//First loop will find the "THeaderValue" value in header.
		for (int i=1;i<=3;i++){
			String sColValue = null;
			sColValue = driver.findElement(By.xpath("//*[@id='post-2924']/div[1]//div[1]//table/tbody/tr[1]/th["+i+"]")).getText();
			if(sColValue.equalsIgnoreCase(THeaderValue)){
				
				// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
				System.err.println("\n The column " + sColValue+" Is :" );
				
				for (int j=01;j<=3;j++){
					String sRowValue= driver.findElement(By.xpath("//*[@id='post-2924']/div[1]//div[1]//table/tbody/tr["+j+"]/td["+i+"]")).getText();
					System.out.println("\n The Row Value: "+sRowValue);
				}
			break;
		}
	}
	}
	
	@AfterMethod
	public void TreaDown() {
		System.out.println("@Aftermethod");
		driver.quit();
	}

}
