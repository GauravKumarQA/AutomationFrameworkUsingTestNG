package pageObjects;

import java.util.ArrayList;

import org.testng.annotations.Test;

import utils.ReadwriteExcel;

public class excel {
	String countername="";
	@Test
	public void test(){
		
	ReadwriteExcel exobj = new ReadwriteExcel("C:\\Users\\gaurav\\AppData\\Roaming\\Skype\\My Skype Received Files\\FCM Core.xlsx");
	int rowcount = exobj.getRowCount("Performance report");
	System.out.println(rowcount);
	ArrayList <String> hell = new ArrayList<String>();
	String st  = exobj.getCellDataByColumnName("Performance report",1,"COUNTER");
	System.out.println(st);
	hell.add(st);
	for(int i =2 ; i<=(rowcount-1);i++){
		String countername = exobj.getCellDataByColumnName("Performance report",i,"COUNTER");
		if(hell.contains(countername)){
			System.out.println(countername);
			System.out.println("contains---->"+i);
		}else{
			System.out.println("added++++++++++++++++++++++++++++");
			hell.add(countername);
		}
	
		
	}
	
	int size = hell.size();
	System.out.println(size+"========is size of array");
	
	
	System.out.println(hell.get(0));
	
	for(int counterRes = 0;counterRes <= hell.size();counterRes++){
		
		String countNameInHell = hell.get(counterRes);
		exobj.createNewSheet(countNameInHell);
		
		System.out.println("sheet created");

		
		for(int j =2 ; j<=(rowcount-1);j++){
			
			String countername2 = exobj.getCellDataByColumnName("Performance report",j,"COUNTER");
			System.out.println(countername2);
			if(countername2.contains(countNameInHell)){
				System.out.println( exobj.getIntCellDataByColumnName("Performance report",j,"RESPONSE"));
				exobj.setCellData(countNameInHell, 2, j, exobj.getIntCellDataByColumnName("Performance report",j,"RESPONSE"));				
			}
	}
	}
}
}