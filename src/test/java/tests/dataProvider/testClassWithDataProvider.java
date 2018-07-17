package tests.dataProvider;

import org.testng.annotations.Test;

public class testClassWithDataProvider extends dataProviderClass{

	@Test(dataProvider="testData")
	public void testDataProvider(String parameter1, String perameter2){
		System.out.println(parameter1 + "---" + perameter2);
	}

}
