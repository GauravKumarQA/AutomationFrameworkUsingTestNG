package tests.basicAnnotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuitTest {

	/**
	 * 	BeforeSuite annotation method runs only once before all tests from the suite.
	 */
			
	@BeforeSuite
	public void berforeSuite(){
		System.out.println("Having coffee BeforeSuite ");
	}
	
	
	/**
	 * AfterSuite annotation method runs only once after all tests from the suite.
	 */
	@AfterSuite
	public void afterSuit(){
		System.out.println("After suite only work and sleep ");
	}
}
