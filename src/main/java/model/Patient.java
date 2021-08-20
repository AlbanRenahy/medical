package model;
import Entity.PatientEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSourceFactory;



public class Patient extends AccessDB {
		
		public Patient(String url, String username, String password) {
			super(url, username, password);
		}
		
		public List<PatientEntity> fetchAllPatient() throws SQLException, Exception {
			
			List<PatientEntity> patients = new ArrayList<PatientEntity>();
			Statement statement = this.connexion().createStatement();
			ResultSet result;
			try {
				result = statement.executeQuery("select patient.id,patient.nom,patient.prenom, patient.dateDeNaissance, patient.sexe, patient.numeroSecuriteSocial, adresse.numero, adresse.rue, adresse.cp, adresse.ville, infirmiere.nom AS nomInfirmiere, infirmiere.prenom AS prenomInfirmiere from patient left join adresse on patient.adresse_id= adresse.id left join infirmiere on patient.infirmiere_id= infirmiere.id;");
				
				
				while(result.next()) {
					patients.add(new PatientEntity(
							result.getInt("id"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("dateDeNaissance"),
							result.getString("sexe"),
							result.getInt("numeroSecuriteSocial"),
							result.getString("numero"),
							result.getString("rue"),
							result.getInt("cp"),
							result.getString("ville"),
							result.getString("nomInfirmiere"),
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
		
		public void addAdresse(String numero, String rue, int cp, String ville) throws Exception
	    {
	        //Statement statement = this.connexion().createStatement();
	        //ResultSet result;
	        
	        try {
	            
	            //statement.executeUpdate("INSERT INTO adresse(numero,rue,cp,ville) "+ "values("+numero+","+rue+","+cp+","+ville+")");

	 

	            //statement.executeUpdate("INSERT INTO adresse(numero,rue,cp,ville) "
	                    //+ "values("+numero+","+rue+","+cp+","+ville+")");
	            
	            //statement.execute("INSERT INTO adresse VALUES(`numeroAdresse`,`rueAdresse`,`int(cpAdresse)`,`villeAdresse`)");

	 

	            
	            String query = "INSERT INTO adresse(numero,rue,cp,ville) VALUES(?,?,?,?)";
	            PreparedStatement preparedStmt = this.connexion().prepareStatement(query);
	              preparedStmt.setString(1,numero);
	              preparedStmt.setString (2, rue);
	              preparedStmt.setInt(3,cp);
	              preparedStmt.setString (4, ville);
	              preparedStmt.execute();
	              
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            this.connexion().close();
	        }
	    }
		
		public HashMap<Integer,String> fetchAllAdresses() throws Exception {
			   
		    HashMap<Integer,String> adresses = new HashMap<Integer,String>();
		   
		    Statement statement = this.connexion().createStatement();
		    ResultSet result;
		   
		    try {
		        result = statement.executeQuery("SELECT * FROM adresse");
		        while(result.next()) {
		           
		            adresses.put(result.getInt("id"), result.getString("numero")+" "+result.getString("rue")
		            +" "+result.getString("cp")+" "+result.getString("ville"));   
		        }
		       
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        this.connexion().close();
		    }
		   
		    return adresses;
		    }
		
		public void addPatient(String nom, String prenom, String dateDeNaissance, String sexe, int numeroSecuriteSocial, int adresse_id, int infirmiere_id ) throws Exception {
			String sql ="INSERT into patient (nom, prenom, dateDeNaissance, sexe, numeroSecuriteSocial, adresse_id, infirmiere_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = this.connexion().prepareStatement(sql);
			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, dateDeNaissance);
			statement.setString(4, sexe);
			statement.setInt(5, numeroSecuriteSocial);
			statement.setInt(6, adresse_id);
			statement.setInt(7, infirmiere_id);
		}
	}
