package model;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Entity.DeplacementEntity;
import Entity.InfirmiereEntity;
import Entity.PatientEntity;

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
	
	public DeplacementEntity oneDeplacement(int id) throws Exception { 

		DeplacementEntity deplacement = new DeplacementEntity();
		
		Statement statement = this.connexion().createStatement();
		ResultSet result;
		
		try {
			result = statement.executeQuery("SELECT * FROM deplacement where id=" + id);
			while(result.next()) {
				deplacement.setId(id);
				deplacement.setDate(result.getDate("date"));
				deplacement.setCout(result.getDouble("cout"));
				deplacement.setPatient_id(result.getInt("patient_id"));
				PatientEntity p = new PatientModel().onePatient(deplacement.getPatient_id());
				deplacement.setNomPatient(p.getNom());
				deplacement.setPrenomPatient(p.getPrenom());
				deplacement.setInfirmiere_id(result.getInt("infirmiere_id"));
				InfirmiereEntity i = new InfirmiereModel().oneInfirmiere(deplacement.getInfirmiere_id());
				deplacement.setNomInfirmiere(i.getNom());
				deplacement.setPrenomInfirmiere(i.getPrenom());
			}
		}
		
		catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.connexion().close();
			}
      return deplacement;
	}

	public void updateDeplacement(int id, double cout, LocalDate date, int infirmiere_id, int patient_id) throws Exception {
		try {
			PreparedStatement ps = this.connexion().prepareStatement("UPDATE deplacement SET patient_id=?, infirmiere_id=?, cout=?, date=? where id=?");
			ps.setInt(1, patient_id);
			ps.setInt(2, infirmiere_id);
			ps.setDouble(3, cout);
			ps.setObject(4, date);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}
	}
	
	public void addDeplacement(int id, String nomPatient, String prenomPatient, Date date, double cout,
			String nomInfirmiere, String prenomInfirmiere) throws Exception {
		int patient_id = addPatient(nomPatient, prenomPatient);
		int infirmiere_id = addInfirmiere(nomInfirmiere, prenomInfirmiere);

		Statement statement = this.connexion().createStatement();
		String query="SELECT" + patient_id + " FROM patient WHERE nom=" + nomPatient;
		statement.executeQuery(query);

		String query2 = "INSERT INTO deplacement (patient_id,date,cout, infirmiere_id) VALUES (" + patient_id
				+ ",?,?,?)";

		PreparedStatement pstmt = this.connexion().prepareStatement(query2);
		pstmt.setObject(1, date);
		pstmt.setDouble(2, cout);
		pstmt.setInt(3, infirmiere_id);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	private int addInfirmiere(String nomInfirmiere, String prenomInfirmiere) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int addPatient(String nomPatient, String prenomPatient) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteDeplacement(int id) throws SQLException, Exception {

		Statement statement = this.connexion().createStatement();
		try {
			statement.executeUpdate("DELETE FROM deplacement WHERE id=" + id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

	}
}
