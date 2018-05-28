package A1_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendParameterTo_WebDriver {

public WebDriver driver;

//(Method Receive Parameter )
	
	// ::Note:: Tester can send method Parameter (url, browser) to method throw xml or CMD command ===	
	// CMD command: java -cp "libs\*;bin" -Durl=https://www.facebook.com/ -Dbrowser=chrome org.testng.TestNG D:\Eclips_Source\eclipse_Mars2_WorkSpace\Tutorial\src\WebDriver\Run_WD_Case2.xml

	@BeforeMethod
	// Define parameters = method parameter in @parameter
	@Parameters({ "url", "browser" })

	// Define method with parameters 
	public void setup(String url, String browser) {
		System.out.println("@BeforeMethod");
		System.out.println("Send parameter to WebDriver by xml or CMD");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 	
		driver.get(url);
	}

@Test
	public void Login() {

		driver.findElement(By.id("email")).sendKeys("ahmed_ocp1@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("1020304050");

		driver.findElement(By.id("loginbutton")).click();

		// =========== Assert after in home page ==============
		Boolean xpathv = driver.findElement(By.xpath("//html[@id='facebook']//div[@id='u_0_a']//a[@title='Profile']//span[@class='_1vp5']")).isDisplayed();

		if (xpathv == true) // compare message content
			System.out.println("Test case is pass - user successfully login");
		else {
			System.out.println("Test case is fail - user can not login");
		}
	}
	
	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
