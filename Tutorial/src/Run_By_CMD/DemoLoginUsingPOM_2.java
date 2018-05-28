package Run_By_CMD;

/*
 *  WordPress login" test script
 *  Pass parameter from CMD"
 *  
 *  
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class DemoLoginUsingPOM_2 {

	protected WebDriver driver; // Create_instance_from_WebDriver_to_current_machine
	protected WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		//1- added to pass parameter & browser value from CMD
		String paramvalue=System.getProperty("param1");
		System.out.println("Sent Value 1 is: " +paramvalue);

		String browser = System.getProperty("browser");
		System.out.println("Sent Value 2 is: " +browser);

		System.out.println("@BeforeMethod");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if

		(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();

/*-Run script using xml send pararmeter value + browser value= chrome-
 * ======================================================================
2- Point 3 in CMD command file: 
java -cp "libs\*;bin" -DParam1=TestItworks -Dbrowser=chrome org.testng.TestNG D:\Eclips_Source\eclipse_Mars2_WorkSpace\Tutorial\src\Run_By_CMD\Run2.xml

OR for firefox

java -cp "libs\*;bin" -DParam1=TestItworks -Dbrowser=firefox org.testng.TestNG D:\Eclips_Source\eclipse_Mars2_WorkSpace\Tutorial\src\Run_By_CMD\Run2.xml		
 		
 */
		
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
