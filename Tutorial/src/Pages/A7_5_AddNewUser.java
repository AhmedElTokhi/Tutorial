package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class A7_5_AddNewUser {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// Constructor used to call this class from other scripts (as @before)
	public A7_5_AddNewUser(WebDriver driver) {
	//super();
		//Make class driver= method input driver that will be sent from test Case (that create object from this class)
		this.driver = driver;
		wait = new WebDriverWait(driver, 40, 100);
	}

	//Locators
	By TextUserName =By.cssSelector("[name='user_login']");
	By TextEmail 	=By.cssSelector("[name='email']");
	By Text1stName 	=By.cssSelector("[name='first_name']");
	By TextLatsName =By.cssSelector("[name='last_name']");
	By TextWebsite 	=By.cssSelector("[name='url']");
	By ShowPassword =By.xpath("//td/button[@type='button']");
	By TextPassword =By.xpath("//input[@id='pass1-text']");
	By Confirm		=By.xpath("//input[@name='pw_weak']");
	By ButtonAddNewUser =By.xpath("//input[@id='createusersub']");
//	By AssertAddedUser =By.linkText("UserName")("//*[@id='user-1']/td[1]/strong/a");

	//Business
	public void AddNewUserData (String UserName, String Email, String FirstName, String LastName, String WebSite, String PassWord ) throws Exception{
		
		
		Thread.sleep(1000);
		//Add UserName
		driver.findElement(TextUserName).clear();
		driver.findElement(TextUserName).sendKeys(UserName);
		
		Thread.sleep(1000);
		//Add Email
		driver.findElement(TextEmail).clear();
		driver.findElement(TextEmail).sendKeys(Email);
		
		Thread.sleep(1000);
		//Add FirstName
		driver.findElement(Text1stName).clear();
		driver.findElement(Text1stName).sendKeys(FirstName);
		
		Thread.sleep(1000);
		//Add LastName
		driver.findElement(TextLatsName).clear();
		driver.findElement(TextLatsName).sendKeys(LastName);
		
		Thread.sleep(1000);
		//Add WebSite
		driver.findElement(TextWebsite).clear();
		driver.findElement(TextWebsite).sendKeys(WebSite);

		Thread.sleep(1000);
		//Add Password
		driver.findElement(ShowPassword).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(TextPassword));
		
		driver.findElement(TextPassword).clear();
		driver.findElement(TextPassword).sendKeys(PassWord);
		
		// click Confirm CheckBox to Activate "Add Button"
		Thread.sleep(1000);
		driver.findElement(Confirm).click();
		
		Thread.sleep(1000);
		//Click AddNewUser
		driver.findElement(ButtonAddNewUser).click();	
	}
	
	// have to be in "Users Page" but we leave it for "Step by Step" training.
	public void AssertAddedUser (String UserName){
		
		WebElement elemTable = driver.findElement(By.xpath("//div[3]/form/table"));

		// 2) Get all the Rows of table from this elemTable variable.
		List<WebElement> trlist = elemTable.findElements(By.tagName("tr"));
		
		// String variable to be used in Assertion
		String Assetwith = null;
		
		//for tester check on console
//		System.out.println("Row number " + trlist.size());
		for (WebElement elemTr : trlist) {

			// Fetch the columns from a particular row (for each row)
			List<WebElement> tdlist = elemTr.findElements(By.xpath("td"));

			//for tester check on console
//			System.out.println("Column size" + tdlist.size());

			for (WebElement w : tdlist) {

				String S = w.getText();
				
				//for tester check on console
//				System.out.println("Current cell Value: " + S);

				if (S.contains(UserName)) {
					Assetwith = S;	
					break;
				}
			}
		}
		// Assert for table contain (Search keyword)
		Assert.assertTrue(Assetwith.contains(UserName));
		System.err.println("list contain value: " + UserName);
	}
}
