package ScreenShot_for_Web;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShots {
	WebDriver driver;

	@Test
	public void testCalc01() throws InterruptedException {
	
		System.out.println("check ScreenShot in path and fail cases");
	}

	@BeforeMethod
	public void setup() {

			driver = new ChromeDriver();
			driver.get("https://juliemr.github.io/protractor-demo/");
	}

// ============= use ScreenShot in after to take screenshot after complete @test============
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

	// define object to get time to print it in file name
		long timestamp = System.currentTimeMillis();

	// define if condition to separate between success / fail screenshot 
		if(result.isSuccess())
	// Use (utils) package -that define by Eng.Mahmoud- to use getscreenshot method
			utils.ScreenCapture.getScreenShot(driver, "./screenshots/myimg."+timestamp+".png");
		else
			utils.ScreenCapture.getScreenShot(driver, "./screenshots/myimg.failed."+timestamp+".png");
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
