package model;
import Entity.PatientEntity;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PatientModel extends AccessDB {

	public PatientModel() {
		super();
	}


	public List<PatientEntity> fetchAllPatient() throws Exception {

		List<PatientEntity> patients = new ArrayList<PatientEntity>();

		Statement statement = this.connexion().createStatement();
		ResultSet result;

		try {
			result = statement.executeQuery("SELECT * FROM patient");
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

	public PatientEntity onePatient(int id) throws Exception {

		PatientEntity patient = new PatientEntity();

		Statement statement = this.connexion().createStatement();
		ResultSet result;

		try {
			result = statement.executeQuery("SELECT * FROM patient WHERE id=" + id);
			while(result.next()) {
				patient.setId(id);
				patient.setAdresse_id(result.getInt("id"));
				patient.setInfirmiere_id(result.getInt("infirmiere_id"));
				patient.setNom(result.getString("nom"));
				patient.setPrenom(result.getString("prenom"));
				patient.setDateDeNaissance(result.getString("dateDeNaissance"));
				patient.setSexe(result.getString("sexe"));
				patient.setNumeroSecuriteSocial(result.getInt("numeroSecuriteSocial"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

		return patient;
	}

	public void addPatient( String nom, String prenom, String sexe, String dateDeNaissance, int numeroSecuriteSocial, int infirmiere_id, String numero, String rue, int cp, String ville ) throws Exception {
			int adresse_id=addAdresse(numero, rue, cp, ville);
			String query = "INSERT INTO patient (nom, prenom, sexe, dateDeNaissance, numeroSecuriteSocial, infirmiere_id, adresse_id  ) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = this.connexion().prepareStatement(query);
			pstmt.setString(1,nom);
			pstmt.setString(2,prenom);
			pstmt.setString(3,sexe);
			pstmt.setString(4,dateDeNaissance);
			pstmt.setInt(5,numeroSecuriteSocial);
			pstmt.setInt(6, infirmiere_id);
			pstmt.setInt(7, adresse_id );
			
			pstmt.executeUpdate();
			pstmt.close();

			}
			

	public int addAdresse(String numero, String rue, int cp, String ville) throws Exception {
		 Connection con = this.connexion();
	     PreparedStatement ps = con.prepareStatement("select * from adresse where numero=? and rue=? and cp=? and ville=? ");
	     ps.setString(1,numero);
	     ps.setString(2,rue);
	     ps.setInt(3, cp);
	     ps.setString(4,ville);
	     int adresse_id=0;
	     ResultSet rs = ps.executeQuery();
	     if(rs.next()) {
	         adresse_id = rs.getInt("id");
     }
     else {
         PreparedStatement ps2 = con.prepareStatement("insert into adresse(numero,rue,cp,ville) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
         ps2.setString(1,numero);
         ps2.setString(2,rue);
         ps2.setInt(3, cp);
         ps2.setString(4,ville);
         ps2.executeUpdate();
         try (ResultSet generatedKeys = ps2.getGeneratedKeys()) {
             if (generatedKeys.next()) {
                 adresse_id = generatedKeys.getInt(1);
             }
             else {
                 throw new SQLException("Creating adress failed, no ID obtained.");
             }
         }

     }
     return adresse_id;
	}

	public void updatePatient(int id, String nom, String prenom, String sexe, String dateDeNaissance, int numeroSecuriteSocial) throws Exception {

		Statement statement = this.connexion().createStatement();

		try {
			statement.executeUpdate("UPDATE patient SET nom='" + nom + "', prenom='" + prenom + "', dateDeNaissance='" + dateDeNaissance + "', sexe='" + sexe + "', numeroSecuriteSocial='" + numeroSecuriteSocial + "' WHERE id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}
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
