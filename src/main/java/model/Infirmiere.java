package model;
import Entity.InfirmiereEntity;
import Entity.PatientEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Infirmiere extends AccessDB {
		
		public Infirmiere(String url, String username, String password) {
			super(url, username, password);
		}
		
		public List<InfirmiereEntity> fetchAllInfirmiere() throws SQLException, Exception {
			
			List<InfirmiereEntity> infirmieres = new ArrayList<InfirmiereEntity>();
			Statement statement = this.connexion().createStatement();
			ResultSet result;
			try {
				result = statement.executeQuery("SELECT * from infirmiere left join adresse on infirmiere.adresse_id = adresse.id");
				
				while(result.next()) {
					infirmieres.add(new InfirmiereEntity(
							result.getInt("id"),
							result.getInt("adresse_id"),
							result.getInt("numeroProfessionnel"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getInt("telPro"),
							result.getInt("telPerso")
							));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.connexion().close();
			}
			
			return infirmieres;
		}
	}