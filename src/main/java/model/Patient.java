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
			result = statement.executeQuery(
					"select patient.id,patient.nom,patient.prenom, patient.dateDeNaissance, patient.sexe, patient.numeroSecuriteSocial, adresse.numero, adresse.rue, adresse.cp, adresse.ville, infirmiere.nom AS nomInfirmiere, infirmiere.prenom AS prenomInfirmiere from patient left join adresse on patient.adresse_id= adresse.id left join infirmiere on patient.infirmiere_id= infirmiere.id;");

			while (result.next()) {
				patients.add(new PatientEntity(result.getInt("id"), result.getString("nom"), result.getString("prenom"),
						result.getString("dateDeNaissance"), result.getString("sexe"),
						result.getInt("numeroSecuriteSocial"), result.getString("numero"), result.getString("rue"),
						result.getInt("cp"), result.getString("ville"), result.getString("nomInfirmiere"),
						result.getString("prenomInfirmiere")

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

		return patients;
	}

	public void deletePatient(int id) throws SQLException, Exception {

		Statement statement = this.connexion().createStatement();
		try {
			statement.executeUpdate("DELETE FROM deplacement WHERE patient_id=" + id);
			statement.executeUpdate("DELETE FROM patient WHERE id=" + id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

	}
}
