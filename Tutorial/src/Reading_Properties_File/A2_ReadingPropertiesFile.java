package Reading_Properties_File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class A2_ReadingPropertiesFile {

	
	protected Properties Prop=null;
	protected FileInputStream LoadFile=null;
	
	public A2_ReadingPropertiesFile (String FilePath) throws IOException{
		Prop=new Properties();
		LoadFile= new FileInputStream(FilePath);
		Prop.load(LoadFile);
	}
	
	public String GetBrowser (){
		return Prop.getProperty("browser");
	}
	
	public String GetURL(){
		return Prop.getProperty("URL");
	}
	
	public String GetUserName(){
		return Prop.getProperty("Username");
	}
	
	public String GetPassword(){
		return Prop.getProperty("Password");
	}
	
}
