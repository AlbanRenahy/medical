package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class AccessDB {

		private String url;
		private String password;
		private String username;
		
		public AccessDB(String url, String username, String password) {
			this.url = url;
			this.username = username;
			this.password = password;
		}
		
		/**
		AccessDB() {
			this.url = "jdbc:mysql://localhost:3306/medical";
		    this.password = "root";
		    this.username = "root";
		}
		*/
		
		
		public Connection connexion() throws Exception { 
			
			Connection con = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(this.url, this.username, this.password);
			
			return con;
		}
}
