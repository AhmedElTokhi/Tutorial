package New_Window;
// Script Reference http://www.seleniumeasy.com/selenium-tutorials/perform-operations-on-new-window-using-webdriver

// Description for  main function (move to other instance of driver and come back) ....in (Test Pro) course day4 Presentation.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewWindowExamples {
	public static WebDriver driver;

	@Test
	public void verifySearchInNewWindow() throws InterruptedException {

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		String mainHandle = driver.getWindowHandle();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='iframeResult']")));
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/button")).click();
		
		Thread.sleep(3000);

// ===== Page 2==== 
		//Switch to new window and verify the title ----switch Web driver focus to (page 2)
		utils.NewWindow.waitForNewWindowAndSwitchToIt(driver);
		String newTitle = utils.NewWindow.getCurrentWindowTitle(driver);
		Assert.assertEquals(newTitle, "W3Schools Online Web Tutorials", "New window title is not matching");
		System.out.println("\n================\now we focus on 'page 2': "+newTitle);  //for tester
		
		// Verify the text present on the page
		String textOnpage = driver.findElement(By.xpath("//div[@class='w3-main']/div[1]/div[1]/h1[.='HTML']")).getText().trim();
		Assert.assertEquals(textOnpage, "HTML");

// ===== Page 1==== 
		//Close all opened widows regardless main page ----switch Web driver focus to (Main Page)
		utils.NewWindow.closeAllOtherWindows(driver, mainHandle);
		Thread.sleep(3000);		//for tester 

		// Verify main window (current page) the title
		newTitle = utils.NewWindow.getCurrentWindowTitle(driver);
		Assert.assertEquals(newTitle, "Tryit Editor v3.5", "main window title is not matching");
		System.out.println("\n================\now we focus on 'Main Page': "+newTitle);  //for tester
		Thread.sleep(4000);
		
	}

	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
