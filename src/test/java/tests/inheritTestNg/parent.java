package tests.inheritTestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class parent {

	@BeforeTest
	public void beforeTestChild(){
		System.out.println("Before test in parent");
	}
	
	
	
	/**
	 * Before method will run only before test of parent
	 */
	@BeforeMethod 
	public void beforeParentMethod(){
		System.out.println("Before method in parent");
	}
	
	@Test
	public void parentTest(){
		System.out.println("I am in parent test");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("i am after method in parent");
	}
	
}
