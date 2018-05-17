package testCases;

import org.testng.annotations.*;

public class groupAnnotations {

	@BeforeGroups("yellow")
	public void beforeGroup(){
		System.out.println("I am before yellow");
	}
	
	@BeforeGroups("green")
	public void beforeGroupTwo(){
		System.out.println("I am before grean");
	}
	
	@Test(groups="yellow")
	public void testGroupsOne(){
		System.out.println("test before group yellow");
	}
	
	@Test(groups="yellow")
	public void testGroupsTwo(){
		System.out.println(" test before group yellow 2nd");
	}
	
	@Test(groups="green")
	public void testGroupsThree(){
		System.out.println("test before group green");
	}
	
	@Test(groups="green")
	public void testGroupsFour(){
		System.out.println("test before group green2");
	}
	
	@AfterGroups("yellow")
	public void afterGroupOne(){
		System.out.println("After groups yellow");
	}
	
	@AfterGroups("green")
	public void afterGroupTwo(){
		System.out.println("After groups green");
	}
	

}
