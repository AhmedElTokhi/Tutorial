package Reading_Properties_File;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FaceBookLogin_______Utils_ReadProperities {

	public WebDriver driver;

	@BeforeTest
	public void Setup() throws IOException {
		System.out.println(":@BeforeTest");
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./config1.properties");

		// Read (Browser) from property file throw method in [utils] Package and add it in String variable [browser].
		String browser = data.GetBrowser();

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		// Read URL from property file throw method in [utils] Package
		driver.get(data.GetURL());

	}

	@Test
	public void FaceBooklogin() throws IOException {
		System.err.println("@test:TestCase1");

		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./config1.properties");

		// Pass [User name] to element after Read from property file throw method in [utils] Package
		driver.findElement(By.id("email")).sendKeys(data.GetUserName());
		// Pass [Password] to element after Read from property file throw method in [utils] Package
		driver.findElement(By.id("pass")).sendKeys(data.GetPassword());
		driver.findElement(By.id("loginbutton")).click();

	}

	@AfterTest
	public void quit() {
		System.out.println(":@AfterTest");
		driver.quit();
	}

}
