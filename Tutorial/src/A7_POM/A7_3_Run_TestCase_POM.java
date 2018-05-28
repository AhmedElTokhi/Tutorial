package A7_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.A7_2_Login_Class_POM;
import Pages.A7_4_HomePage_Class_POM;
import Pages.A7_5_AddNewUser;

public class A7_3_Run_TestCase_POM {

	WebDriver driver = new ChromeDriver();

	// @Test
	public void TestValidLgin() throws Exception {
		A7_2_Login_Class_POM login = new A7_2_Login_Class_POM(driver);
		login.LoginSteps("admin", "pass");

		login.AssertWelcome();
	}

	// @Test
	public void TestInvalidUser() throws Exception {
		A7_2_Login_Class_POM login = new A7_2_Login_Class_POM(driver);
		login.LoginSteps("Ahmed", "pass");

		login.assertError("ERROR");
	}

	// @Test
	public void TestInvalidPass() throws Exception {
		A7_2_Login_Class_POM login = new A7_2_Login_Class_POM(driver);
		login.LoginSteps("admin", "Pa$$");

		login.assertError();
	}

	// === After Add homePage Class ========================
	// @Test
	public void AddNewPost() throws Exception {

		A7_2_Login_Class_POM login = new A7_2_Login_Class_POM(driver);
		login.LoginSteps("admin", "pass");

		A7_4_HomePage_Class_POM HP = new A7_4_HomePage_Class_POM(driver);

		HP.AssertWelcome();

		HP.NavigateNewPost();

		// HP.NavigateToPosts();
		Thread.sleep(1000); // for tester to see result
	}

	@Test
	public void AddNewUser() throws Exception {
		A7_2_Login_Class_POM login = new A7_2_Login_Class_POM(driver);
		A7_4_HomePage_Class_POM hpage = new A7_4_HomePage_Class_POM(driver);
		A7_5_AddNewUser newuser= new A7_5_AddNewUser(driver);
		
		login.LoginSteps("admin", "pass");
		hpage.AssertWelcome();
		
		hpage.NavigateToAddUser();
		
		newuser.AddNewUserData("User2", "bb@cc.com", "Ashraf2", "22", "www.google.com", "987654321");
		
		
		Thread.sleep(2000);
		newuser.AssertAddedUser("User2");
		Thread.sleep(1000);
	}

	@BeforeMethod
	public void Setup() {
		System.out.println(":@BeforeMethod");

		driver.manage().window().maximize();
		driver.get("https://demos1.softaculous.com/WordPress/wp-login.php");
	}

	@AfterMethod
	public void TearDown() {
		System.out.println(":@AfterMethod");
		driver.quit();
	}
}
