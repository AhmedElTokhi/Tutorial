package Assertion;

import static org.testng.Assert.assertEquals;

/* Search Mechanism and Action for (TextArea)and (checkBox, RadioButton, button, links)*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assertion {

 public static WebDriver driver;
	
	@BeforeMethod									
	public void setup(){
	System.err.println("@BeforeMethod");
	driver= new ChromeDriver();						  
	driver.get("https://www.facebook.com/");       
 }	
	
	@Test											
	public static void TestCase1() throws Exception{
		System.err.println("@test:TestCase1");
		 

		driver.findElement(By.id("email")).sendKeys("ahmed_ocp1@hotmail.com");
		driver.findElement(By.name("pass")).sendKeys("123456789");	 			 				            		
		driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
		Thread.sleep(2000);
		
//=== Assertion ========================================
		
		String errMSG = driver.findElement(By.cssSelector("._4rbf._53ij")).getText();  	//Find (error Message) by (CssSelector). 
		System.out.println(errMSG);												 		// Print error message
		
	//=== Assert True ============================
		// (More Flexible)
		Assert.assertTrue(errMSG.contains("incorrect"));		
		Assert.assertTrue(errMSG.equals("The password that you've entered is incorrect. Forgotten password?"));

		// IgnorCase not consider with Upper (ABC) and lower Case (abc)
		Assert.assertTrue(errMSG.equalsIgnoreCase("The password that you've entered is incorrect. Forgotten password?")); 
		
		String loginCtr=driver.findElement(By.xpath("/*[@id='pass']")).getText();
		Assert.assertTrue(loginCtr.isEmpty());
		
	  //=== Assert Equals =========================
		//Assert.assertEquals("Expected Text", "Actual Text", "If Assert is false (Display Text)");
		Assert.assertEquals("The password that you've entered is incorrect. Forgotten password?",errMSG ,"Error message note as expected");
		assertEquals("The password that you've entered is incorrect. Forgotten password?",errMSG ,"Error message note as expected");
		
//		Assert.assertEquals("Expected Text", "Actual Text");
		Assert.assertEquals(errMSG, "The password that you've entered is incorrect. Forgotten password?");
		
		//=== Assert False ==========================
		Assert.assertFalse(errMSG.contains("Test text"));
		
	  //=== Assert Not Equals =====================		
		//Assert.assertNotEquals("Expected Text", "Actual Text");
		Assert.assertNotEquals("Test Text",errMSG);
	
	  //=== Assert Null ===========================	
		
		String test1=null;
		Assert.assertNull(test1);
		
	  //=== Assert Not Null =======================	
		Assert.assertNotNull(errMSG);

	  //=== Assert Same ===========================		
		test1=errMSG;
		Assert.assertSame(test1,errMSG);

	  //=== Assert Not Same =======================		
		test1=null;
		Assert.assertNotSame(test1,errMSG);
		String test2="Ahmed";
		Assert.assertNotSame(test1,errMSG, test2);
			
	  //=== Assert Using Wait =====================
		WebDriverWait  wait= new WebDriverWait(driver, 60, 250);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-4")));

		//wait.until(ExpectedConditions.attributeContains(By.cssSelector("box"),"name","txt"));
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("._4rbf._53ij"),"getText", "The password that you've entered is incorrect. Forgotten password?"));
		// in (ExpectedConditions.attributeContains) in attribute is "innerText"
	}
 
	@AfterMethod									
	public static void TearDown(){
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
