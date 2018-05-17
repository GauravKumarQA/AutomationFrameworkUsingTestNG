package testCases;

import org.testng.annotations.*;

public class MethodAnnotations {

	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method");
	}
	
	@Test
	public void testMethodOne(){
		System.out.println("Test to before method1");
	}
	
	@Test
	public void testMethodTwo(){
		System.out.println("Test to before method2");
	}
	
	@AfterMethod
	public void testAfterMethod(){
		System.out.println("After method");
	}
	
}
