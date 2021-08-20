package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.InfirmiereEntitySimple;

public class InfirmiereDao {

	    private static String jdbcURL = "jdbc:mysql://localhost:3306/medical";
	    private static String jdbcUsername = "root";
	    private static String jdbcPassword = "root";

	    private static final String INSERT_INFIRMIERE_SQL = "INSERT INTO infirmiere" + "  (adresse_id,numeroProfessionnel,nom,prenom,telPro,telPerso) VALUES " +
	        " (?, ?, ? ,? ,? ,?);";

	    private static final String SELECT_INFIRMIERE_BY_ID = "select id,nom,prenom,telPro,telPerso from infirmiere where id =?";
	    private static final String SELECT_ALL_INFIRMIERES = "select * from infirmiere";
	    private static final String DELETE_INFIRMIERE_SQL = "delete from infirmiere where id = ?;";
	    private static final String UPDATE_INFIRMIERE_SQL = "update infirmiere set adresse_id = ? nom = ?,prenom= ?, numeroProfessionnel =?, telPerso= ?, telPro= ?, where id = ?;";

	    public InfirmiereDao() {}

	    protected static Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public static void insertInfirmiere(InfirmiereEntitySimple infirmiere) throws SQLException {
	        System.out.println(INSERT_INFIRMIERE_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INFIRMIERE_SQL)) {
	        	preparedStatement.setInt(1, infirmiere.getAdresse_id());
	        	preparedStatement.setInt(2, infirmiere.getNumeroProfessionnel());
	        	preparedStatement.setString(3, infirmiere.getNom());
	            preparedStatement.setString(4, infirmiere.getPrenom());
	            preparedStatement.setInt(5, infirmiere.getTelPro());
	            preparedStatement.setInt(6, infirmiere.getTelPerso());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    public static InfirmiereEntitySimple selectInfirmiere(int id) {
	    	InfirmiereEntitySimple infirmiere = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INFIRMIERE_BY_ID);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int adresse_id = rs.getInt("adresse_id");
	            	int numeroProfessionnel = rs.getInt("numeroProfessionnel");
	                String nom = rs.getString("nom");
	                String prenom = rs.getString("prenom");
	                int telPro = rs.getInt("telPro");
	                int telPerso = rs.getInt("telPerso");
	                infirmiere = new InfirmiereEntitySimple(id,adresse_id,prenom,  nom, numeroProfessionnel, telPro, telPerso);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return infirmiere;
	    }

	    public static List < InfirmiereEntitySimple > selectAllInfirmieres() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < InfirmiereEntitySimple > infirmieres = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INFIRMIERES);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                int adresse_id = rs.getInt("adresse_id");
	            	int numeroProfessionnel = rs.getInt("numeroProfessionnel");
	                String nom = rs.getString("nom");
	                String prenom = rs.getString("prenom");
	                int telPro = rs.getInt("telPro");
	                int telPerso = rs.getInt("telPerso");
	                infirmieres.add(new InfirmiereEntitySimple(id,adresse_id,prenom,  nom, numeroProfessionnel, telPro, telPerso));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return infirmieres;
	    }

	    public boolean deleteInfirmiere(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); 
	        		PreparedStatement statement = connection.prepareStatement(DELETE_INFIRMIERE_SQL);
	        		) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    public static boolean updateInfirmiere(InfirmiereEntitySimple infirmiere) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_INFIRMIERE_SQL);) {
	        	statement.setInt(1, infirmiere.getId());
	        	statement.setInt(2, infirmiere.getAdresse_id());
	        	statement.setString(3, infirmiere.getNom());
	            statement.setString(43, infirmiere.getPrenom());
	            statement.setInt(5, infirmiere.getTelPro());
	            statement.setInt(6, infirmiere.getTelPerso());
	            statement.setInt(7, infirmiere.getNumeroProfessionnel());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }

	    private static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}

