package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A7_4_HomePage_Class_POM {

	protected WebDriver driver;
	protected WebDriverWait wait;

	// Constructor used to call this class from other scripts (as @before)
	 public A7_4_HomePage_Class_POM(WebDriver driver) {
		// super();
		
		//Make class driver= method input driver that will be sent from test Case (that create object from this class)
		this.driver = driver;
		wait = new WebDriverWait(driver, 40, 100);
	}

	// Locators
	By WelcomeMSGLocator = By.cssSelector("#welcome-panel h2");
	By PostsLocator = By.cssSelector("#menu-posts  div.wp-menu-name");
	By AddNewPostLocator = By.cssSelector("#menu-posts > ul > li:nth-child(3) > a");
	By UsersLocator = By.cssSelector("#menu-users .wp-menu-name");
	By AddNewUserLocator = By.partialLinkText("Add New");		// Preferred when link test is available (for 1 language and other language tested in smoke test)
//OR 		
//	By AddNewUserLocator = By.xpath("//a[@href='user-new.php']");  // not based on language
//OR 	
//	By AddNewUserLocator = By.xpath("//*[contain(.,'Add New')] or (.,'≈÷«›… ÃœÌœ')]"); //For multi-Language ** Need check syntax.
 

	
	// Business
	public void AssertWelcome() {
		wait.until(ExpectedConditions.attributeContains(WelcomeMSGLocator, "innerText", "Welcome to WordPress!"));
	}

	public void NavigateToPosts (){
		driver.findElement(PostsLocator).click();
	}
	
	public void NavigateNewPost() throws Exception {
		Actions MAction = new Actions(driver);
		
//=========== Mouse Action ==================================
	 // MAction.moveToElement(driver.findElement(PostsLocator)).click(driver.findElement(AddNewPostLocator)).click().build().perform();
		// in current sample there are waiting time up to appear sup menu
		// SO separate action in 2 step to add wait time as following
// ==========================================================	
		MAction.moveToElement(driver.findElement(PostsLocator)).perform();
// ========== wait ==========================================
		wait.until(ExpectedConditions.elementToBeClickable(AddNewPostLocator));
		//OR
		//Thread.sleep(1000);
		
// ========== last click ====================================
		MAction.moveToElement(driver.findElement(AddNewPostLocator)).click().perform();
		//OR
		// driver.findElement(AddNewPostLocator).click();
	}
	
	public void NavigateToUsers (){
		driver.findElement(UsersLocator).click();
	}
	
	public void NavigateToAddUser(){
		Actions Maction= new Actions(driver);
		
		Maction.moveToElement(driver.findElement(UsersLocator)).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(AddNewUserLocator));
		Maction.moveToElement(driver.findElement(AddNewUserLocator)).click().perform();
	//OR
//		driver.findElement(AddNewUserLocator).click();
	}

}
