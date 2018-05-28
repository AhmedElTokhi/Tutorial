package utils;

import java.awt.image.BufferedImage;

//Script Reference (Eng.Mhmoud) Test_Pro course

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ScreenCapture {

	public static void getFullScreenShot(WebDriver driver,String fileToSave) throws IOException{
		//capture screen shoot with a .png format.
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(fileToSave));
	}
	
	
	public static void getPartScreenShot(WebDriver driver, By ElementLocaltor, String fileToSave) throws IOException{
		WebElement ele = driver.findElement(ElementLocaltor);

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation =  new File(fileToSave);
		FileUtils.copyFile(screenshot, screenshotLocation);
	}
}