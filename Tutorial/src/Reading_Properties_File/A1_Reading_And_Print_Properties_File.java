package Reading_Properties_File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class A1_Reading_And_Print_Properties_File {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream("./ReadFrom/config1.properties");
		prop.load(fis);
		
		System.out.println("URL: "+ prop.getProperty("URL"));
		System.out.println("Browser: "+ prop.getProperty("browser"));
		System.out.println("Username: "+ prop.getProperty("Username"));
		System.out.println("Password: "+ prop.getProperty("Password"));
		
	}
	
}
