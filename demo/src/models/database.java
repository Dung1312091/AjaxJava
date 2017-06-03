package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
public Connection con;
	
	public void openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		if(con==null || con.isClosed()){
			// Load the Connector/J driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establish connection to MySQL
			Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection
			   ("jdbc:mysql://localhost:3306/appdemo", "root", "");
		}
		
	}
	public void closeConnection() throws SQLException{
		if(con!=null || !con.isClosed()){
			con.close();
		}
	}
	public ResultSet getlisttheloai(String query) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		openConnection();
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}
	public ResultSet getlistloaitin(String query) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		openConnection();
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}
	public ResultSet getlisttintuc(String query) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		openConnection();
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}

}
