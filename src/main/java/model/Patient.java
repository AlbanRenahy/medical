package model;
import Entity.PatientEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Patient extends AccessDB {
		
		public Patient(String url, String username, String password) {
			super(url, username, password);
		}
		
		public List<PatientEntity> fetchAllPatient() throws SQLException, Exception {
			
			List<PatientEntity> patients = new ArrayList<PatientEntity>();
			Statement statement = this.connexion().createStatement();
			ResultSet result;
			try {
				result = statement.executeQuery("SELECT * from patient");
				
				while(result.next()) {
					patients.add(new PatientEntity(
							result.getInt("id"),
							result.getInt("adresse_id"),
							result.getInt("infirmiere_id"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("dateDeNaissance"),
							result.getString("sexe"),
							result.getInt("numeroSecuriteSocial")
							));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.connexion().close();
			}
			
			return patients;
		}
	}
