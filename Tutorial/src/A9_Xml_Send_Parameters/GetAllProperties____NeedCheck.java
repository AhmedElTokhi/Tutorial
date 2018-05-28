package A9_Xml_Send_Parameters;

// Reference: https://www.roseindia.net/java/example/java/util/GetAllProperties.shtml
import java.io.*;
import java.util.*;

public class GetAllProperties____NeedCheck{
  public static void main(String[] args){
  Properties pro = new Properties();

  try{
  System.out.print("Enter file name for getting all properties : ");
  FileInputStream in = new FileInputStream("config.properties");
  
  pro.load(in);
  
  System.out.println("All keys of the property file : ");
  System.out.println(pro.keySet());
  
  System.out.println("All values of the property file : ");
  Enumeration em = pro.keys();
  while(em.hasMoreElements()){
  String str = (String)em.nextElement();
  System.out.println(str + ": " + pro.get(str));
  }
  }
  catch(IOException e){
  System.out.println(e.getMessage());
  }
  }
}
