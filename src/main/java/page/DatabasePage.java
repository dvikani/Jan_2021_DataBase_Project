package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabasePage {
  
	public static String getData(String columName) throws Throwable {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sqlUrl = "jdbc:mysql://localhost:3306/jan2021"; // conneting to the localhost, can get from MySQL Workbench Databace n connet
		String sqlUserName = "root"; // SQL username
		String sqlPassword = "root"; // SQL Password
		String query = "select * from users;";
		// Creating a connection to your local Database
		Connection con = DriverManager.getConnection(sqlUrl, sqlUserName, sqlPassword);
		// Connection is an inbuild Interface, can't use the objet of the interface so need to class that can implement the interface 
		Statement smt = con.createStatement(); //Empowering the con ref variable to execute queries 
		ResultSet rs = smt.executeQuery(query);//Executing query
		while(rs.next()) {
			return rs.getString(columName);
		}
		
		return columName;
		
	}
	
}
