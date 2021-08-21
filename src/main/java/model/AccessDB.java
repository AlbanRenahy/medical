package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccessDB {

	private String url;
	private String username;
	private String password;
	
	public AccessDB() {
		this.url = "jdbc:mysql://localhost:3306/medical"; 
		this.password = "root";
		this.username = "root";
	}
	
	/**
	public void DbDAO() {
		
	}
	 * @throws Exception 
	*/
	
	public Connection connexion() throws Exception {
		
		Connection con = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(this.url, this.username, this.password);
		
		return con;
	}
}
