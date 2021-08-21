package model;

import Entity.InfirmiereEntity;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InfirmiereModel extends AccessDB{

	public InfirmiereModel() {
		super();
	}

	public List<InfirmiereEntity> fetchAllInfirmiere() throws Exception {

		List<InfirmiereEntity> infirmieres = new ArrayList<InfirmiereEntity>();

		Statement statement = this.connexion().createStatement();
		ResultSet result;

		try {
			result = statement.executeQuery("SELECT * FROM infirmiere");
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
	

	public InfirmiereEntity oneInfirmiere(int id) throws Exception { 

		InfirmiereEntity infirmiere = new InfirmiereEntity();
		
		Statement statement = this.connexion().createStatement();
		ResultSet result;
		
		try {
			result = statement.executeQuery("SELECT * FROM infirmiere as i, adresse as a WHERE i.adresse_id=a.id and i.id=" + id);
			while(result.next()) {
				infirmiere.setId(id);
				infirmiere.setAdresse_id(result.getInt("id"));
				infirmiere.setNumeroProfessionnel(result.getInt("numeroProfessionnel"));
				infirmiere.setNom(result.getString("nom"));
				infirmiere.setPrenom(result.getString("prenom"));
				infirmiere.setTelPerso(result.getInt("telPerso"));
				infirmiere.setTelPro(result.getInt("telPro"));
				infirmiere.setNumero(result.getString("numero"));
				infirmiere.setRue(result.getString("rue"));
				infirmiere.setCp(result.getInt("cp"));
				infirmiere.setVille(result.getString("ville"));
			}
		}
		
		catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.connexion().close();
			}
      return infirmiere;
	}


	public void addInfirmiere(int numeroProfessionnel, String nom, String prenom, int telPro, int telPerso, String numero, String rue, int cp, String ville) throws Exception{
		Connection con = this.connexion();
		int adresse_id = addAdresse(numero, rue, cp, ville);
		Statement statement = con.createStatement();
		try {
			statement.executeUpdate("INSERT INTO infirmiere (adresse_id, numeroProfessionnel, nom, prenom, telPro, telPerso) VALUES ( "+adresse_id+", " + numeroProfessionnel + ", '" + nom + "', '" + prenom + "', " + telPro + ", " + telPerso + " )");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}
  }
    
	public void deleteInfirmiere(int id) throws SQLException, Exception {

		Statement statement = this.connexion().createStatement();
		try {
			statement.executeUpdate("DELETE FROM deplacement WHERE infirmiere_id=" + id);
			statement.executeUpdate("DELETE FROM patient WHERE infirmiere_id=" + id);
			statement.executeUpdate("DELETE FROM infirmiere WHERE id=" + id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

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

	public void updateInfirmiere(int id, String nom, String prenom, String numPro, int telPerso, int telPro,String numero, String rue, int cp, String ville) throws Exception {
		
		int adresse_id = addAdresse(numero, rue, cp, ville);
		try {
			Statement statement = this.connexion().createStatement();
			statement.executeUpdate("UPDATE infirmiere SET nom='" + nom + "', prenom='" + prenom + "', numeroProfessionnel='" + numPro + "', telPerso='" + telPerso + "', telPro='" + telPro + "', adresse_id="+ adresse_id+" WHERE id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}
		
	}

}