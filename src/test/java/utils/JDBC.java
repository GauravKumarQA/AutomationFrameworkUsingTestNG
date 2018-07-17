package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	// ==========Initializers
	Connection con;
	Statement stm;
	ResultSet set;

	public JDBC(String databaseType, String hostAddress, String portNumber, String dataBaseName, String username,
			String password) throws Exception {

		if (databaseType.equalsIgnoreCase("mysql")) {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("MySql database driver loaded");
				Connection con = DriverManager.getConnection("jdbc:mysql://" + hostAddress + ":" + portNumber + "/"
						+ dataBaseName,username,password);
				System.out.println("connected to" + databaseType);
				stm = con.createStatement();
			
		} else if (databaseType.equalsIgnoreCase("mssql")) {
			
		} else if (databaseType.equalsIgnoreCase("MangoDB")) {

		} else {
			System.out.println("we will add " + databaseType + " Soon..");
		}
	}

	public Statement getCurrentStatement() {
		return stm;
	}

	public ResultSet executeQuery(String query) throws SQLException {
		return stm.executeQuery(query);
	}

}
