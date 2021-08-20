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
			result = statement
					.executeQuery("SELECT * from infirmiere left join adresse on infirmiere.adresse_id = adresse.id");

			while (result.next()) {
				infirmieres.add(new InfirmiereEntity(result.getInt("id"), result.getInt("adresse_id"),
						result.getInt("numeroProfessionnel"), result.getString("nom"), result.getString("prenom"),
						result.getInt("telPro"), result.getInt("telPerso"), result.getInt("numero"),
						result.getString("rue"), result.getInt("cp"), result.getString("ville")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connexion().close();
		}

		return infirmieres;
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
}