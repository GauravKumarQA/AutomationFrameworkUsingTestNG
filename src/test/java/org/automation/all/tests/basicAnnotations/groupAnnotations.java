package org.automation.all.tests.basicAnnotations;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupAnnotations {

	/**
	 * @BeforeGroups
	 * The list of groups that this configuration method will run before. 
	 * This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked. 
	 */
	@BeforeGroups(groups = "yellow")
	public void beforeGroup(){
		System.out.println("I am before yellow");
	}


	@BeforeGroups(groups = "green")
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

	@AfterGroups(groups = "yellow")
	public void afterGroupOne(){
		System.out.println("After groups yellow");
	}


	/**
	 * The list of groups that this configuration method will run after.
	 *  This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked. 
	 */
	@AfterGroups(groups = "green")
	public void afterGroupTwo(){
		System.out.println("After groups green");
	}


}
