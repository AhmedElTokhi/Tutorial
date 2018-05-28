package A9_Xml_Send_Parameters;

//Reference: https://www.mkyong.com/java/java-properties-file-examples/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Load_properties_file____NeedCheck {
		
	  public static void main(String[] args) {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("./config.properties");

			// load a properties file
			prop.load(input);   
			
// ******** Need check because it print Null *************

			
			// get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("browser"));
					
					
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	  }
	}
