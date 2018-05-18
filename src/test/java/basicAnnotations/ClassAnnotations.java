package basicAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassAnnotations {

	/**
	 * 	BeforeClass Method runs only once before the first test method. The Current Class method will be one from which it is invoked.
	 */
	@BeforeClass
	public void beforeClassTest(){
		System.out.println("Do revision before your class");
	}
	
	@Test
	public void testClass(){
		System.out.println("Test to before and after test");
	}
	
	
	/**
	 * AfterClass annotation method runs only once when all the test methods mentioned in the current class are executed.
	 */
	@AfterClass
	public void afterClassTest(){
		System.out.println("Play games after class");
	}	

}
