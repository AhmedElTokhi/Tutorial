package New_Window;

// ***********************Other Code need check and research******************************

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_Windows___ {

	public static void main(String[] args) throws Exception {	


//	To open a second window you'll need to use something in Selenium to force a second window. The trick is to use JavascriptExecutor to run javascript which opens a second window, e.g.

	//The first two lines are straight forward and open a window with the admin tool. 
	WebDriver driver = new ChromeDriver();
	driver.get("adminToolURL");

	//get a list of the currently open windows
	Set<String> windows = driver.getWindowHandles();
	//save the window handle for the admin tool window
    String adminToolHandle = driver.getWindowHandle();

	//open a new window using executeScript
	((JavascriptExecutor)driver).executeScript("window.open();");

	//get a second list of the currently open window (this will be the same as the first list PLUS the new window)
	Set<String> customerWindow = driver.getWindowHandles();

	//Next remove all the original windows handles from the second list. This should leave the second list (customerWindow) with only one window handle
	customerWindow.removeAll(windows);
	String customerSiteHandle = ((String)customerWindow.toArray()[0]);
	driver.switchTo().window(customerSiteHandle);
	driver.get("customerSiteURL");
	driver.switchTo().window(adminToolHandle);

	//e.g. the new window. The last three lines show you how to switch between the customer site window and the admin tool window.
	
// ========== Presentation code==========
//	Set<String> handles = driver.getWindowHandles(); // Get all handles
//	String currentHandle= driver.getWindowHandle(); // Get current handle
//	String z;
//	
//	for(String Handle:handles){					// Go on all windows
//	           If (!Handle.equals(currentHandle)){
//				
//				
//				driver.switchTo().window (Handle);			//switch to Other window 
//
//				// now driver affect in the new window
//				
//					if (isElementPresent(By.xpath("some component in the page"))){ 
//					// check specific page's items 
//					}
//			
//				}
//	        }
//	driver.switchTo().window(currentHandle);
//}

	
	}
}
