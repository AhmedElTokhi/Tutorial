package A3_FindElement;

/* Search Mechanism and Action for (TextArea)and (checkBox, RadioButton, button, links)*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A3_2_Driver_Action {

 public static WebDriver driver;
	
	@BeforeMethod									
	public void setup(){
	System.err.println("@BeforeMethod");
	driver= new ChromeDriver();						  
       
 }	

	
	@Test											
	public static void FindElement_Approachs () throws Exception{
		System.err.println("@test:TestCase1");
		driver.get("https://www.facebook.com/");		

//======== TextArea Action ==========================================================
		
		WebElement element1=driver.findElement(By.id("email"));

		//and Action for TextArea is (Clear) action and (SendKeys).
		element1.clear();
		element1.sendKeys("ahmed_ocp1@hotmail.com");
		
		//and Action for TextArea is (SendKeys).If text not have a text (Clear) is not needed -.
		driver.findElement(By.name("pass")).sendKeys("123456789");	 			 		
	
	//OR	
		// *****************************************************************************
		// ****** In Case of cannot find control identification (id, name, xpath) ******
		// *****************************************************************************
		// Enter value in text area useing_sendKeys.(Keys.TAB + "text value");
//		driver.findElement(By.id("email")).sendKeys(Keys.TAB +"123456789");
		
//========== (CheckBox, RadioButton, button)Action ============================
				
		Thread.sleep(1000);
		
		// The (checkBox, RadioButton, button, links) Action for is (click).
		driver.findElement(By.xpath("//input[@value='Log In']")).click();     

	//OR	
		// **************************************************************
		// **** In Send Key (Keys. ) can do keyboard button actions *****
		// **************************************************************
//		driver.findElement(By.xpath("//*[@id='u_0_2']")).sendKeys(Keys.ENTER);
		
//=========== (Message) action ========================================================
		
		Thread.sleep(2000);
		
		// Message like (getTest)/(IsDisplayed)/....up to usage
		String errMSG = driver.findElement(By.cssSelector("[class='_4rbf _53ij']")).getText();
		System.out.println(errMSG);
	}
		 	
//	@Test
	public void Find_linkText () throws Exception{

		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL

		// 1- Login using admin/ pass
				driver.findElement(By.id("user_login")).sendKeys("admin");
				driver.findElement(By.id("user_pass")).sendKeys("pass");
				driver.findElement(By.id("wp-submit")).click();

				Thread.sleep(5000);

		// 2-Click Post tab in menu
		driver.findElement(By.cssSelector("#menu-posts .wp-menu-name")).click();
		
//========== (links)Action ============================================================
		
		driver.findElement(By.linkText("Add New")).click();
		driver.findElement(By.partialLinkText("Add New")).click();

}
	@AfterMethod									
	public static void TearDown(){
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
