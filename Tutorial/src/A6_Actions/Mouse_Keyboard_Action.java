package A6_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mouse_Keyboard_Action {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.amazon.com/ref=nav_logo"); // Use_(get)function_of_new_instance_to_send_URL
		driver.manage().window().maximize();
	}

// Compound Action: 
//(click-and-hold, double-click, contextClick, drag-and-drop, drag-and-drop-by, key-down, key-up, move-by-offset, move-to-element, release)	
// ===============
//::Reference:: ***********"check reference document in project"***********	

/* ::Note:: 
 * 1- All Actions must end with .perform(); to be executed.
 * 2- build() method is used compile all the listed actions into a single step. 
 * We use build() when we are performing sequence of operations and no need to use if we are performing single action.*/
	
	@Test
//====================== Mouse action =====================
	public void Mouse_Actions() throws Exception {
		
	// practice for (Move To Element)
		Actions MHover= new Actions (driver);
		MHover.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]/span"))).perform();
		MHover.moveToElement(driver.findElement(By.cssSelector("#nav-link-shopall > span.nav-line-2 > span"))).perform();
		MHover.moveToElement(driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-template.nav-flyout-content.nav-tpl-itemList > span:nth-child(11) > span"))).perform();

	// practice for (Move by Offset)		
		MHover.moveByOffset(50, 700).perform();
		
		driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-subcats > div:nth-child(10) > div.nav-column.nav-column-notfirst.nav-column-break > div > a:nth-child(2) > span")).click();
		Thread.sleep(2000);		
	}
	
	@Test
	public void Keyboard_Actions() throws Exception {
//====================== Mouse action =====================		
	// practice for (Mouse hover action)
		
/*::Note::
	some keys not fully work and resolved by work around like:
	https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/6817
	*/ 	
		Actions KeyAction= new Actions (driver);
		
		KeyAction.click().perform();  			//Need Sample
		KeyAction.doubleClick().perform();		//Need Sample
		KeyAction.clickAndHold().perform();		//Need Sample
		KeyAction.contextClick().perform();		//Need Sample
		KeyAction.keyDown(Keys.F1).perform(); 
		KeyAction.keyUp(Keys.F1).perform();	
		//----------
		KeyAction.clickAndHold().perform();		//Need Sample
		
	
		driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-subcats > div:nth-child(10) > div.nav-column.nav-column-notfirst.nav-column-break > div > a:nth-child(2) > span")).click();
		Thread.sleep(2000);		
	}	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
	}
