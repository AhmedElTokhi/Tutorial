package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class A7_2_Login_Class_POM {

	/*protected: Who "use class" by create object, can NOT use it.
	 * 			 Who "inherit class" can use it.
	 */
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	//Constructor  used to call this class from other scripts (as @before)
	public A7_2_Login_Class_POM(WebDriver driver) {
		//super();
		
		//Make class driver= method input driver that will be sent from test Case (that create object from this class)
		this.driver=driver;
		wait= new WebDriverWait(driver, 60, 10);
	}

	// 1- Locators ==
	// ===============
	By TextUserName = By.id("user_login");
	By TextUserPass = By.id("user_pass");
	By ButtonSubmit = By.id("wp-submit");
	By WelcomeMSGLocator = By.cssSelector("#welcome-panel h2");
	By ErrorMSGLocator = By.xpath("//*[@id='login_error']");

	// 2- Business ==
	// ===============
	/*protected: Who "use class" by create object, can NOT use it.
	 * 			 Who "inherit class" can use it.
	 * 
	 * ::Note:: Protected method is not visible for another package 
	 */
	public void LoginSteps(String User, String Pass) {
		driver.findElement(TextUserName).sendKeys(User);
		driver.findElement(TextUserPass).sendKeys(Pass);
		driver.findElement(ButtonSubmit).click();
	}

	// have to be in "Home Page" but we leave it for "Step by Step" training.
	public void AssertWelcome() throws Exception{
		wait.until(ExpectedConditions.attributeContains(WelcomeMSGLocator, "innerText", "Welcome to WordPress!"));
	}	
	
	public void assertError() {
		wait.until(ExpectedConditions.attributeContains(ErrorMSGLocator, "innerText", "ERROR"));
	}

	public void assertError(String error) {
		 wait.until(ExpectedConditions.attributeContains(ErrorMSGLocator,"innerText",error));
//		assertError();
//		String errMSG = (driver.findElement(ErrorMSGLocator).getAttribute("innerText"));
//		Assert.assertTrue(errMSG.contains("ERROR"));
	}
}
