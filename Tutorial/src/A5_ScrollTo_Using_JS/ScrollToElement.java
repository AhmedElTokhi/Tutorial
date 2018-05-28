package A5_ScrollTo_Using_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollToElement {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine
	
	@BeforeMethod
	public void setup() {
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/"); // Use_(get)function_of_new_instance_to_send_URL
	}

/*::Reference:: ***********"check reference document in project"***********
	 
::Note:: (java script) 
 * 1- We can search for java script command search keyword(how to get element by id in javascript). like click on page button (Department)(document.getElementById("nav-link-shopall").click();)
 * 2- We can check java script code in web page (console)by click (Ctrl+Shift+j).... Because actually selenium deal with page Data Object Model (DOM). 
 * 3- but this JS in selenium object (JavascriptExecutor) as following:
 */
	
	@Test
	public void Findxpath() throws Exception {
		
// ===== Scroll using javascript code up to defined value in WebElement variable ================

		WebElement element =driver.findElement(By.xpath("//*[@title='Make your next career move to our brilliant company.']"));
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
//		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

//OR	Reuse same code from utils Package
		utils.Scroll.ScrollToElement(driver, element);

		Thread.sleep(2000);
		

	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
