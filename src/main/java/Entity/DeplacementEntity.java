package Entity;

public class DeplacementEntity {
	
	private int id;
	private int id_patient;
	private String nom_patient;
	private String prenom_patient;
	private int id_infirmiere;
	private String nom_infirmiere;
	private String prenom_infirmiere;
	private String date;
	private double cout;
	


	public DeplacementEntity(int id, String nom_patient, String prenom_patient,
			String nom_infirmiere, String prenom_infirmiere, String date, double cout) {
		super();
		this.id = id;
		this.id_patient = id_patient;
		this.nom_patient = nom_patient;
		this.prenom_patient = prenom_patient;
		this.id_infirmiere = id_infirmiere;
		this.nom_infirmiere = nom_infirmiere;
		this.prenom_infirmiere = prenom_infirmiere;
		this.date = date;
		this.cout = cout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	public String getPrenom_patient() {
		return prenom_patient;
	}

	public void setPrenom_patient(String prenom_patient) {
		this.prenom_patient = prenom_patient;
	}

	public String getNom_patient() {
		return nom_patient;
	}

	public void setNom_patient(String nom_patient) {
		this.nom_patient = nom_patient;
	}

	public int getId_infirmiere() {
		return id_infirmiere;
	}

	public void setId_infirmiere(int id_infirmiere) {
		this.id_infirmiere = id_infirmiere;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public String getPrenom_infirmiere() {
		return prenom_infirmiere;
	}

	public void setPrenom_infirmiere(String prenom_infirmiere) {
		this.prenom_infirmiere = prenom_infirmiere;
	}

	public String getNom_infirmiere() {
		return nom_infirmiere;
	}

	public void setNom_infirmiere(String nom_infirmiere) {
		this.nom_infirmiere = nom_infirmiere;
	}
	
	

}
