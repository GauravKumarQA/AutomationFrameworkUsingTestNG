package tests.basicAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations {

	/**
	 * BeforeTest method runs before any test method inside the <test> tag is run. 
	 * (in testNG.xml file). It runs before the execution of classes takes place.
	 */
	@BeforeTest
	public void beforeTest(){
		System.out.println("I am before test");
	}

	@Test
	public void testTest(){
		System.out.println("Test to test");
	}
	
	/**
	 * AfterTest method runs after any test method inside the <test> tag is run. 
	 * (in testNG.xml file). It runs after the execution of classes takes place.
	 */
	@AfterTest
	public void afterTest(){
		System.out.println("I am after test");
	}
}
