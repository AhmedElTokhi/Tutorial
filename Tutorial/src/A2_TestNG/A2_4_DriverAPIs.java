package A2_TestNG;

/* WebDriver APIs */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A2_4_DriverAPIs {

 public static WebDriver driver;
	
	@BeforeMethod									
	public void setup(){
	System.err.println("@BeforeMethod");
	driver= new ChromeDriver();						  
	driver.get("https://www.facebook.com/");						// Open entered URL; Not Return value.       
 }	
	
	@Test											
	public static void TestCase1() throws Exception{
		System.err.println("@test:TestCase1");

		//(4)=== Get ===
		driver.get("https://www.facebook.com/");						// Open entered URL; Not Return value.
		
		//(5)=== Get current URL ===
		driver.getCurrentUrl();												// Get current WebDriver URL -In Case of URL changed up to action- as an assertion step.
	
		//(6)=== Get Page Source ===
		driver.getPageSource();  										// dump html source in file - to re-check html page content during testing time-

		//(7)=== GetTitle ===
		driver.getTitle();													// Get Page title - as an assertion step-.  	
		
		//(8)=== Get Window Handle ===
		driver.getWindowHandle();										// Get current page.
				
		//(9)=== Get Window Handles ===
		driver.getWindowHandles();											// Get list of all opened page.  	
						
		//(10)=== Manage ===   ** Currently selenium start to deprecate its functionality **
		driver.manage().window().maximize();							// Manage driver configuration. 
		
		//(11)=== Navigate===    
		driver.navigate().back();											// Navigate to browser actions like (Back, Forward, Refresh) or entered URL  	
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("http://www.microsoft.com");		

		//(12)=== Switch To ===
		driver.switchTo();
		driver.switchTo().window("");									// Switch to driver focus to (window, frame, Alert,...)
		driver.switchTo().frame("");
		driver.switchTo().alert();
		
		//(14)=== Wait ===		Related to Java								// Manage Wait time up to page load or do action.
		driver.wait(30, 250);												
		driver.wait(20);		
		driver.wait(30, 300);
		
		//(2)=== Find 1 Element ===
		WebElement emailField;											// Create instance of (WebElement)
		emailField = driver.findElement(By.id("email"));   				// Use (WebElement)instance to Find 1 Element by id -it return 1 WebElement-; 
																		//if not find Element it crash (Stop script)
		emailField.sendKeys("ahmed_ocp1@hotmail.com");				 	// Send value to this element (email).
		
		driver.findElement(By.id("pass")).sendKeys("123456789");	 	// Find 1 Element by id and Send value to it.		


		//(3)=== Find List of Elements ===		
		List <WebElement> L1= driver.findElements(By.id("pass"));			// Find List of (Elements / Element) ; 
																			// if not find Element it NOT crash (script continue running)
		System.out.println(L1);
		
 }
 
	@AfterMethod									
	public static void TearDown(){
		System.err.println("@AfterMethod");
		//(1)=== Close ===
		driver.close();         // Terminate current window.

		//(10)=== Quit ===
		driver.quit();			//terminate Driver session that include all (opened windowS).
	}
}
