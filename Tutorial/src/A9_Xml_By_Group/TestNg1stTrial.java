package A9_Xml_By_Group;

/*::Note::
1- Create XML for smoke test, Sanity test, Full Regression, ....
2- and (Jenkins) / other build tool: manage execution xml based on other task result like (If  "smoke test" run "Sanity test").
*/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg1stTrial {

	public static void main(String[] args) {
		System.err.println("main");
	}
	@BeforeMethod(alwaysRun=true)							// 2- Add (alwaysRun=true) to (@BeforeMethod) and (@AfterMethod).
															// 3- define selected Groups in XML file, and can define xml for smoke, xml for sanity.
	public void prep(){
		String value=System.getProperty("key");
		System.out.println("TestNg1stTrial==@BeforeMethod");
	}
	
	@Test(groups={"smock","grp0"})							// 1- Add groups name that include this Test Case
	public void testcase1(){
		System.err.println("TestNg1stTrial==@Test  1");
	}

	@Test(groups={"grp0"})
	public void testcase2(){
		System.err.println("TestNg1stTrial==@Test  2");
	}

	@Test(groups={"smok","grp1"})
	public void testcase3(){
		System.err.println("TestNg1stTrial==@Test  3");
	}

	@AfterMethod(alwaysRun=true)							// 2- Add (alwaysRun=true) to (@BeforeMethod) and (@AfterMethod).
	public void cleanup(){
		System.err.println("TestNg1stTrial==@AfterMethod");
	}
	
}
