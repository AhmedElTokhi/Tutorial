package A9_Xml_Send_Parameters;

// Calculator using DDT "Data Driven test" 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Calculator_Para_Default_Value {

	
	private WebDriver driver; // Create_instance_from_WebDriver_to_current_machine

	
	@BeforeMethod ()
	@Parameters ({"url","browser"}) 					//............ 2- Define parameters name (url, browser) = name in step 1.
														//............ 3- Send parameters (url, browser) value via XML file.
//=============== @optional define "default value" in case of not pass value from xml ============================
	public void setup(@Optional("https://juliemr.github.io/protractor-demo/") String url,@ Optional ("chrome") String browser) {

//OR

//Parameter send by xml or CMD command
//	public void setup(String url, String browser) { 	//............ 1- Define Setup input parameter(String url, String browser)
		System.out.println("@BeforeMethod");

		if(browser.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
		}else if 

		(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
// FireFox_Browser ver. 58.0.2 is compatible with FireFoxDriver "geckodriver" ver. 0.19.1 ----as current setup
		
		driver.get(url); 
	}
	
	
	@AfterMethod()
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}

	@Test()
	public void PlusOperator(){
		System.out.println("Print Test: Calculator == @Test");
	}


}
