package A3_FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A3_3_TreeElement__JS {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 60, 250);

	@BeforeMethod
	public void Setup() {
		System.out.println("@BeforeMethod");

		driver.manage().window().maximize();
		driver.get("https://www.jstree.com/");
	}

	// @Test
	public void Tree1Element() throws InterruptedException {
		System.out.println(":@Test");
		
		// 1st click to collapse tree
		driver.findElement(By.xpath("//*[@id='j1_1']/i")).click();
		Thread.sleep(2000);

		// 2nd click to expand tree
		driver.findElement(By.cssSelector("#j1_1 > i")).click();
		Thread.sleep(2000);
	}

	@Test
	public void Tree2Elemnt () throws InterruptedException{
		System.out.println(":@Test");
		
		//click to check 1st CheckBox
		driver.findElement(By.cssSelector("[class='jstree-icon jstree-checkbox']")).click();
		Thread.sleep(2000);
		
		//click to check 1st CheckBox
		driver.findElement(By.xpath("//li[@class='jstree-node  jstree-open']//*[@id='j2_4_anchor']/i[1]")).click();
		
		//Wait until element attribute -that used in assert- to be visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[3]/a[@class='jstree-anchor jstree-clicked']")));
		
		//Assert that CheckBox is checked 
		wait.until(ExpectedConditions.attributeContains(By.xpath("//li[3]/a[@class='jstree-anchor jstree-clicked']"), "class", "jstree-anchor jstree-clicked"));
		System.err.println("The CheckBox is checked");	
		
	}

	@AfterMethod
	public void TreaDown() {
		System.out.println(":@Aftermethod");
		 driver.quit();
	}

}
