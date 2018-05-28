package UploadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Upload_file {

	WebDriver driver;

//	@Test
	public void uploadFile() throws Exception {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
		driver.switchTo().frame("iframeResult");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='myFile']")).sendKeys("D:\\Sally\\1.jpg");

//======== OR use simple steps ========

//		driver.findElement(By.xpath("//*[@id='myFile']")).click();
//		utils.ClipBoard.copy("D:\\Sally\\1.jpg");
//		Thread.sleep(3000);
//		utils.ClipBoard.paste();
//		utils.NativKeyHelper.hitEnter();
		Thread.sleep(3000);
	}

	@Test
	public void uploadFile2 ()throws Exception{
		driver.get("https://www.zamzar.com/");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//input[@id='inputFile']")).sendKeys("D:\\Sally\\1.jpg");

//======== OR use simple steps ========		
//		Thread.sleep(3000);
//		utils.ClipBoard.copy("D:\\Sally\\1.jpg");
//		utils.ClipBoard.paste();
//		Thread.sleep(3000);
//		utils.NativKeyHelper.hitEnter();
		Thread.sleep(3000);
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
