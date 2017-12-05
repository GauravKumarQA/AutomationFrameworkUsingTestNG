package pageObjects;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class test3 {
	public class test2 {
		@Test
		@Parameters({"name"})
		public void gaurav3(@Optional("") String name){
			System.out.println("gaurav3" + name);
		}

	}


}
