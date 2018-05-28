package A3_FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A3_1_2_GetAttribute_Of_Element {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine
	
	@BeforeMethod
	public void setup() {

		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void loginWordPress() throws Exception {

		// 1- Login using admin/ pass
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("pass");
		driver.findElement(By.id("wp-submit")).click();

		Thread.sleep(5000);
	
// ==== Use (getAttribute)======================
		// "innerHTML" get HTML content
		String elemHtml = driver.findElement(By.xpath("//*[@id='welcome-panel']")).getAttribute("innerHTML");
		System.out.println("innerHTML value: "+elemHtml);

		// "innerText" get text without tags
		elemHtml=driver.findElement(By.cssSelector("#welcome-panel h2")).getAttribute("innerText");
		System.out.println("innerText value: "+elemHtml);
		
		// Get attribute "textContent" amount
		elemHtml=driver.findElement(By.cssSelector("#welcome-panel")).getAttribute("textContent");
		System.out.println("textContent value: "+elemHtml);
		
		// Get attribute "placeholder" amount
		elemHtml=driver.findElement(By.cssSelector("#welcome-panel h2")).getAttribute("placeholder");
		System.out.println("placeholder value: "+elemHtml);
		
		// Get attribute "Value" amount
		elemHtml=driver.findElement(By.cssSelector("#welcome-panel h2")).getAttribute("value");
		System.out.println("value value: "+elemHtml);
		
// ==== Use (getText)===========================		
		
	// It get Visible text	
		elemHtml = driver.findElement(By.xpath("//*[@id='welcome-panel']//h2")).getText();
		System.out.println("innerHTML value: "+elemHtml);
		
// ==== Use (getCssValue)======================		

		elemHtml=driver.findElement(By.cssSelector("#welcome-panel h2")).getCssValue("value");
		
		
		elemHtml=driver.findElement(By.cssSelector("#welcome-panel h2")).getTagName();
		

	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
