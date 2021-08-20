package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.DeplacementEntity;


public class Deplacement extends AccessDB {

	public Deplacement(String url, String username, String password) {
		super(url, username, password);
	}
	
	public List<DeplacementEntity> fetchAllDeplacement() throws SQLException, Exception {
		
		List<DeplacementEntity> deplacements = new ArrayList<DeplacementEntity>();
		Statement statement = this.connexion().createStatement();
		ResultSet result;
		try {
			result = statement.executeQuery("select deplacement.id , deplacement.cout, deplacement.date , patient.nom AS nom_patient,patient.prenom AS prenom_patient,infirmiere.nom AS nom_infirmiere, infirmiere.prenom AS prenom_infirmiere "
					+ "from deplacement "
					+ "left join infirmiere on deplacement.infirmiere_id= infirmiere.id "
					+ "left join patient on deplacement.patient_id= patient.id;");
			
			
			while(result.next()) {
				deplacements.add(new DeplacementEntity(
						result.getInt("id"),
						result.getString("nom_patient"),
						result.getString("prenom_patient"),
						result.getString("nom_infirmiere"),
						result.getString("prenom_infirmiere"),
						result.getString("date"),
						result.getDouble("cout")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}	
		return deplacements;
	}
}
