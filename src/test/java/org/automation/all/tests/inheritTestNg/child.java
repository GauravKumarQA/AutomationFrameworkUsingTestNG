package org.automation.all.tests.inheritTestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class child extends parent{

	
	/**estNG guarantees that the "@Before" methods are executed in inheritance order (highest superclass first, then going down the inheritance chain), 
	 * and the "@After" methods in reverse order (going up the inheritance chain).
	 * Before test will run before all test include parent class
	 */
	@BeforeTest
	public void beforeTestChild(){
		System.out.println("Before test in child");
	}

	@Test()
	public void testInchild(){
		System.out.println("Test in child");
	}
	
	
	@Test()
	public void testInchilTwo(){
		System.out.println("Test in child 2");
	}
	
	
	
	/**
	 * Before method will run before each test include parent test
	 */
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("I am before method in child");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("i am after method in child");
	}
	
}
