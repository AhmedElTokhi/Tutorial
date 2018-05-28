package Wait;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitDriver {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://jqueryui.com/menu/"); // Use_(get)function_of_new_instance_to_send_URL
	}

////=============(Use Wait Driver)=======================
	@Test
	public void SmartWait_for_MouseHoverandClick () throws Exception {

// Define wait element with configuration (driver, "Maximum wait time" second, "bulls" MS)
		WebDriverWait  wait= new WebDriverWait(driver, 60, 250);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // *** NOT WORK ***
//		Wait wait2 = new FluentWait(driver). 							  - added by ahmed (Need check)
		 

		Actions maction = new Actions(driver);
		maction.moveToElement(driver.findElement(By.id("ui-id-4"))).build().perform();
		
// ==Use defined wait element.
//============= Wait for Attribute Validation ===========================		
		
//::Note:: NOT ALL "condition list" of (ExpectedConditions.) is working
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-4")));
		
		Thread.sleep(500);		//For tester "To see result"
		maction.click(driver.findElement(By.id("ui-id-7"))).click().perform();
//OR
//		driver.findElement(By.id("ui-id-7")).click();
		Thread.sleep(3000);			//For tester "To see result"
		
		
		//wait.until(ExpectedConditions.attributeContains(By.cssSelector("box"),"Attribute name","txt"));
		//=======Using attribute "innerText" ====== get text without tags
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("._4rbf._53ij"),"innerText", "The password that you've entered is incorrect. Forgotten password?"));
		//=======Using attribute "textContent" ======		
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("._4rbf._53ij"),"textContent", "The password that you've entered is incorrect. Forgotten password?"));
		//=======Using attribute "value" ======		
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("._4rbf._53ij"),"value", "The password that you've entered is incorrect. Forgotten password?"));
		
//============= Waiting for Elements Visibility ==========================		

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='imgbox2']")));  // Valid

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='imgbox2']"))); // Valid
		
// ######### The following methods need example ##############
		
		wait.until(ExpectedConditions.attributeToBe(By.cssSelector("box"),"name","txt1"));
		
		WebElement elementx = driver.findElement(By.cssSelector("#ui-id-2"));	
		wait.until(ExpectedConditions.attributeToBeNotEmpty(elementx,"name"));
		
//============= Waiting for Elements Count ===============================		

		wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("box"),5));
		
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("box"),5));
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("box"),5));
		
//============= Waiting for a text in an element ==========================
		wait.until(ExpectedConditions.textMatches(By.cssSelector("box"),Pattern.compile("(.*)(\\\\d+)(.*)")));
		
		wait.until(ExpectedConditions.textToBe(By.cssSelector("box"),"Sample"));
		
//============= Waiting for an element to be presence ======================
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("ui-id-4")));
		
// =============  Pass value to expected result ============================
		@SuppressWarnings("unused")
		String z= "2";
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'+z+')]")));
	
	}

	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
