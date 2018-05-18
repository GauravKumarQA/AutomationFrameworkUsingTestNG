package dataProvider;

import org.testng.annotations.DataProvider;

public class dataProviderClass {

	@DataProvider(name = "testDatal")
	public Object[][] dataProvider(){
		return new Object[][]{{"Gaurav","Kumar"},{"Chandrika","Bhartiya"}};
	}	
}
