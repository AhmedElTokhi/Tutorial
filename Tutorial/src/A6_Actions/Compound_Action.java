package A6_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Compound_Action {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {
		driver.get("https://jqueryui.com/menu/"); // Use_(get)function_of_new_instance_to_send_URL
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
//====================== compound action need (need wait time)=====================	
	public void MouseHoverandClick() throws Exception {	

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
				
		Actions maction = new Actions(driver);
// =======================================================================================================================================
//		maction.moveToElement(driver.findElement(By.id("ui-id-4"))).click(driver.findElement(By.id("ui-id-7"))).click().build().perform();
// =======================================================================================================================================
// in current sample there are waiting time up to appear sup menu
// SO separate action in 2 step to add wait time as following
		
		maction.moveToElement(driver.findElement(By.id("ui-id-4"))).perform();
		Thread.sleep(500);
// can do it by action click
//		maction.click(driver.findElement(By.id("ui-id-7"))).click().perform();
// can do it with driver click
		driver.findElement(By.id("ui-id-7")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
