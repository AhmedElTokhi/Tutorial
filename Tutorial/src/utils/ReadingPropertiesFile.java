package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	
	protected Properties Prop=null;
	protected FileInputStream LoadFile=null;
	
	public ReadingPropertiesFile (String FilePath) throws IOException{
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
	
	public String GetUserName_Pxadmin(){
		return Prop.getProperty("Username_PXadmin");
	}
	
	public String GetPassword_PXadmin(){
		return Prop.getProperty("Password_PXadmin");
	}
	
	public String GetCustomer_Name(){
		return Prop.getProperty("Customer_Name");
	}
	public String Get1stBranch(){
		return Prop.getProperty("Branch1");
	}
	
	public String Get2ndBranch(){
		return Prop.getProperty("Branch2");
	}
	
	public String GetBranch(int index){
		String str = Prop.getProperty("Branch"+index);
		
		if( str !="" && str!=null)
		{
		
		return str;
		}
		
		return Prop.getProperty("Branch1");
	}
	
	
	
	
	public String GetCountry(){
		return Prop.getProperty("Country");
	}
	
	public String GetZone(){
		return Prop.getProperty("Zone");
	}
	
	public String GetIP(){
		return Prop.getProperty("IP");
	}
	
	public String GetUser_DB(){
		return Prop.getProperty("DBUser");
	}
	
	public String GetPassword_DB(){
		return Prop.getProperty("DBPassword");
	}
	
	public String GetUserName_FB(){
		return Prop.getProperty("Username");
	}
	
	public String GetPassword_FB(){
		return Prop.getProperty("Password");
	}
}
