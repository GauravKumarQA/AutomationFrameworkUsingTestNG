package pageObjects;

import java.util.ArrayList;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.testng.annotations.Test;

import utils.ReadwriteExcel;

public class excel {
	String countername="";
	
	public void test(){
		
	ReadwriteExcel exobj = new ReadwriteExcel("C:\\Users\\Gaurav Chaudhary\\AppData\\Roaming\\Skype\\My Skype Received Files\\FCM Core.xlsx");

	int rowcount = exobj.getRowCount("Performance report");
	System.out.println(rowcount);
	ArrayList <String> hell = new ArrayList<String>();
	String st  = exobj.getCellDataByColumnName("Performance report",1,"COUNTER");
	System.out.println(st);
	hell.add(st);
	for(int i =2 ; i<=(rowcount-1);i++){
		String countername = exobj.getCellDataByColumnName("Performance report",i,"COUNTER");
		if(hell.contains(countername)){
			//System.out.println(countername);
			//System.out.println("contains---->"+i);
		}else{
			//System.out.println("added++++++++++++++++++++++++++++");
			hell.add(countername);
		}
	
		
	}
	
	int size = hell.size();
	System.out.println(size+"========is size of array");
	
	
	System.out.println(hell.get(0));
	
	for(int counterRes = 0;counterRes < hell.size();counterRes++){
		
		String countNameInHell = hell.get(counterRes);
		exobj.createNewSheet(countNameInHell);
		
		System.out.println("sheet created");

		int rowNumber = 0;
		for(int j =1 ; j<=(rowcount-1);j++){
			
			String countername2 = exobj.getCellDataByColumnName("Performance report",j,"COUNTER");
			System.out.println(countername2);
			
			if(countername2.contains(countNameInHell)){
				
				//System.out.println( exobj.getIntCellDataByColumnName("Performance report",j,"RESPONSE"));
				
				String dataToWrite =String.valueOf(exobj.getIntCellDataByColumnName("Performance report",j,"RESPONSE"));
				
				exobj.setTwoCellData(countername2, 1, 2, rowNumber, countername2, dataToWrite);
				
				
				rowNumber++;
			}
	}
		
	}
	
	
	
	
	
	
	
	
}

}