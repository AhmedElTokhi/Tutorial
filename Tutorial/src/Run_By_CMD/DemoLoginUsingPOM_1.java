package Run_By_CMD;

/*
 *  WordPress login" test script
 *  Pass parameter from CMD"
 *  
 *  
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class DemoLoginUsingPOM_1 {

	protected WebDriver driver; // Create_instance_from_WebDriver_to_current_machine
	protected WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		// 1- added to pass value from CMD
		String paramvalue = System.getProperty("Param1");
		System.out.println("Sent Value is: " +paramvalue);

/*-Run script using xml without send parameter-
 * =============================================
2- Point 1 in CMD command file: 
java -cp "libs\*;bin" org.testng.TestNG D:\Eclips_Source\eclipse_Mars2_WorkSpace\Tutorial\src\Run_By_CMD\Run1.xml
		
- Run script using xml and SEND parameter-
 * =============================================
//2- Point 2 in CMD command file: 
//java -cp "libs\*;bin" -DParam1=TestItworks org.testng.TestNG D:\Eclips_Source\eclipse_Mars2_WorkSpace\Tutorial\src\Run_By_CMD\Run1.xml
 		
 */
		driver = new ChromeDriver();
		
		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}

	@Test
	public void testValidLogin() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.loginSteps("demo", "pass");
	}
}
