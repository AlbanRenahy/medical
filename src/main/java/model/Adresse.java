package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.AdresseEntity;

public class Adresse extends AccessDB{
	
	public Adresse(String url, String username, String password) {
		super(url, username, password);
	}
	
	public List<AdresseEntity> fetchAllAdresse() throws SQLException, Exception {
		
		List<AdresseEntity> adresses = new ArrayList<AdresseEntity>();
		Statement statement = this.connexion().createStatement();
		ResultSet result;
		try {
			result = statement.executeQuery("SELECT * from adresse");
			
			while(result.next()) {
				adresses.add(new AdresseEntity(
						result.getInt("id"),
						result.getString("numero"),
						result.getString("rue"),
						result.getInt("cp"),
						result.getString("ville")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}
		
		return adresses;
	}
}
