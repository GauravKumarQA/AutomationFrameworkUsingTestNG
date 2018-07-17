package test.mysqlDataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import utils.JDBC;

public class TestDatabase {

	@Test
	public void testdata() throws Throwable {
		
		JDBC database = new JDBC("MYSQL", "localhost", "3306", "databasetesting", "root", "root");		
		ResultSet set = database.executeQuery("select * from nameofuser");
	
				
	}

}
