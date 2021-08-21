package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.DeplacementEntity;

public class DeplacementModel extends AccessDB {

	public DeplacementModel() {
		super();
	}
	
	public List<DeplacementEntity> fetchAllDeplacement() throws Exception {

		List<DeplacementEntity> deplacements = new ArrayList<DeplacementEntity>();

		Statement statement = this.connexion().createStatement();
		ResultSet result;

		try {
			result = statement.executeQuery("Select d.id, p.nom, p.prenom, d.date, d.cout, i.nom, i.prenom from deplacement d INNER JOIN patient p ON p.id = d.patient_id INNER JOIN infirmiere i ON i.id = d.infirmiere_id");
			while(result.next()) {
					deplacements.add(new DeplacementEntity(
							result.getInt("d.id"),
							result.getString("p.nom"),
							result.getString("p.prenom"),
							result.getDate("d.date"),
							result.getDouble("d.cout"),
							result.getString("i.nom"),
							result.getString("i.prenom")
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
