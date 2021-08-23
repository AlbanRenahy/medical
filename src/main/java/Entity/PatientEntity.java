package Entity;

public class PatientEntity {

	private int id;
	private int adresse_id;
	private int infirmiere_id;
	private String nom;
	private String prenom;
	private String dateDeNaissance;
	private String sexe;
	private int numeroSecuriteSocial;
	private String numero;
	private String rue;
	private int cp;
	private String ville;
	
	
	public PatientEntity() {
	};
	
	public PatientEntity(int id, int adresse_id, int infirmiere_id, String nom, String prenom, String dateDeNaissance,
			String sexe, int numeroSecuriteSocial, String numero, String rue, int cp, String ville ) {
		super();
		this.id = id;
		this.adresse_id = adresse_id;
		this.infirmiere_id = infirmiere_id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.sexe = sexe;
		this.numeroSecuriteSocial = numeroSecuriteSocial;
		this.numero= numero;
		this.rue= rue;
		this.cp=cp;
		this.ville=ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdresse_id() {
		return adresse_id;
	}

	public void setAdresse_id(int adresse_id) {
		this.adresse_id = adresse_id;
	}

	public int getInfirmiere_id() {
		return infirmiere_id;
	}

	public void setInfirmiere_id(int infirmiere_id) {
		this.infirmiere_id = infirmiere_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getNumeroSecuriteSocial() {
		return numeroSecuriteSocial;
	}

	public void setNumeroSecuriteSocial(int numeroSecuriteSocial) {
		this.numeroSecuriteSocial = numeroSecuriteSocial;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}