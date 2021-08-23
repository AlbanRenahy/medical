package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
			result = statement.executeQuery(
					"Select d.id, p.nom, p.prenom, d.date, d.cout, i.nom, i.prenom from deplacement d INNER JOIN patient p ON p.id = d.patient_id INNER JOIN infirmiere i ON i.id = d.infirmiere_id");
			while (result.next()) {
				deplacements.add(new DeplacementEntity(result.getInt("d.id"), result.getString("p.nom"),
						result.getString("p.prenom"), result.getDate("d.date"), result.getDouble("d.cout"),
						result.getString("i.nom"), result.getString("i.prenom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

		return deplacements;
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

	public int addPatient(String nomPatient, String prenomPatient) throws Exception {
		Connection con = this.connexion();
		PreparedStatement ps = con.prepareStatement("select * from patient where nom=? and prenom=?");
		ps.setString(1, nomPatient);
		ps.setString(2, prenomPatient);
		int id = 0;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = rs.getInt("id");
		}
		return id;

	}

	public int addInfirmiere(String nomInfirmiere, String prenomInfirmiere) throws Exception {
		Connection con = this.connexion();
		PreparedStatement ps = con.prepareStatement("select * from infirmiere where nom=? and prenom=?");
		ps.setString(1, nomInfirmiere);
		ps.setString(2, prenomInfirmiere);
		int id = 0;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = rs.getInt("id");

		}
		return id;
	}
}
