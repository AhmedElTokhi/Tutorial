package A2_TestNG;

// Write test script using TestNG approach and check report

//============================================== Reference =================================================
//*** For all TestNG annotation  please check (http://testng.org/doc/documentation-main.html#annotations)***
//==========================================================================================================

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A2_2_HelloTestNG {

	@BeforeMethod									//TestNG annotation (method) will be run before each test method.
 public void setup(){
	System.err.println("@BeforeMethod");
 }	
	@Test(enabled=true, priority=2)					//TestNG annotated a class or a method as part of the test (Run in between of Before & After)
													//(Enable) property to enable this test in execution / or not.
													//(priority) property to define priority of test execution. -by default order it alphabetical-
 public static void TestCase1(){
		System.err.println("@test:TestCase1");
 }
	@Test(enabled=true, priority=1)					//TestNG annotated a class or a method as part of the test (Run in between of Before & After)
	public static void TestCase2(){
		System.err.println("@test:TestCase2");
 }

	public static void TestCase3(){					// This will not executed ?! because it have not (annotation/ marker)
		System.err.println("@test:TestCase3");
 }
	
	@AfterMethod									//TestNG annotated (method) will be run after each test method.
 public static void TearDown(){
		System.err.println("@AfterMethod");
 }
}
