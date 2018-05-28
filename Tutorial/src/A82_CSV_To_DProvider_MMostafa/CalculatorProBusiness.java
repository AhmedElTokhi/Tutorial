package A82_CSV_To_DProvider_MMostafa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorProBusiness {
	
//==============Drivers====================
public WebDriver driver;
protected WebDriverWait wait;
	
//================Constructor===============
public CalculatorProBusiness(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 3 , 100);
	}

//===================Locators============
By firstNumber = By.xpath("//input[@ng-model = 'first']");
By secondNumber = By.xpath("//input[@ng-model = 'second']");
By goButton = By.id("gobutton");
By operMenu = By.tagName("select");



//==================BusinessMethods=========
	public void waitCalculate(String x) 
		{
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(. ,"+x+")]")));
		}
//==========================================

public void mathOperation(String x, String y, String opCode) 
	{
		
		driver.findElement(firstNumber).clear();
		driver.findElement(firstNumber).sendKeys(x+"");
		
		driver.findElement(secondNumber).clear();
		driver.findElement(secondNumber).sendKeys(y+"");
		
		WebElement findElement = driver.findElement(operMenu);
		Select operationSelect = new Select (findElement);
		operationSelect.selectByVisibleText(opCode);
		
		driver.findElement(goButton).click();
	}

}
