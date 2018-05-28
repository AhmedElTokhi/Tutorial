package A7_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A7_1_WordPressLogin_ConvertToPOM {

	/*protected: Who "use class" by create object, can NOT use it.
	 * 			 Who "inherit class" can use it.
	 */
	protected WebDriver driver; // Create_instance_from_WebDriver_to_current_machine
	protected WebDriverWait wait;
	
	// 1- Locators ==
	//===============
	By TextUserName = By.id("user_login");
	By TextUserPass = By.id("user_pass");
	By ButtonSubmit = By.id("wp-submit");
	By WelcomeMSGLocator = By.cssSelector("#welcome-panel h2");
	By ErrorMSGLocator = By.xpath("//*[@id='login_error']");
	
	// 2- Business ==
	//===============
	//Private: Who ("use class" by create object ,"inherit class") can NOT use it -Only for class internal use-
	private void LoginSteps(String User, String Pass) {
		driver.findElement(TextUserName).sendKeys(User);
		driver.findElement(TextUserPass).sendKeys(Pass);
		driver.findElement(ButtonSubmit).click();
	}	
	
	public void AssertMSG(By WelcomeMSGLocator, String ActualWelcomeMessage) {
		wait.until(ExpectedConditions.attributeContains(WelcomeMSGLocator,"innerText", ActualWelcomeMessage));
		}
	// 3- Copy (Locators,Business) in new class -per page- to be (Class per page)= Page Object Model. Check (A7_2_Login_Class_POM)class in (Pages)Package.
	// 4- In (A7_2_Login_Class_POM)class: Create (Constructor) as a class setup in @Before Method.
	
	
	
	// Test Cases ==
	//==============
	@Test
	public void login_ValidUser() throws Exception {
		
		LoginSteps("admin", "pass");
		// Assert	
		AssertMSG(WelcomeMSGLocator, "Welcome to WordPress!");
	}
	
//	@Test
	public void login_InValidUser() throws Exception {

		LoginSteps("Sayed", "pass");
		// Assert		
		AssertMSG(ErrorMSGLocator, "ERROR");
	}
	

//	@Test
	public void login_InValidPass() throws Exception {
		
		LoginSteps("admin", "Pa$$");
		// Assert	
		AssertMSG(ErrorMSGLocator, "ERROR");
	}


	@BeforeMethod
	//public: (Who "use class" , "inherit class") can use it.
	public void setup() {
		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php"); // Use_(get)function_of_new_instance_to_send_URL
		driver = new ChromeDriver(); 
		wait = new WebDriverWait(driver, 60, 100);
	}


	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
