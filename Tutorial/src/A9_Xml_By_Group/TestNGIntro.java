package A9_Xml_By_Group;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {

	public static void main(String[] args) {
		System.err.println("main");
	}
	@BeforeMethod(alwaysRun=true)
	public void prep(){
		System.err.println("TestNGIntro===@BeforeMethod");
	}
	
	@Test(groups={"smock","grp0"})
	public void testcase1(){
		System.err.println("TestNGIntro==@Test  4");
	}

	@Test(groups={"grp0"})
	public void testcase2(){
		System.err.println("TestNGIntro==@Test   5");
	}

	@Test(groups={"smok","grp1"})
	public void testcase3(){
		System.err.println("TestNGIntro==@Test  6");
	}

	@AfterMethod(alwaysRun=true)
	public void cleanup(){
		System.err.println("TestNGIntro==@AfterMethod");
	}
	
}
