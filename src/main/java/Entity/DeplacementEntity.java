package Entity;

import java.util.Date;

public class DeplacementEntity  {

	private int id;
	private int patient_id;
	private String nomPatient;
	private String prenomPatient;
	private Date date;
	private double cout;
	private int infirmiere_id;
	private String nomInfirmiere;
	private String prenomInfirmiere;
	
	public DeplacementEntity() {
	};
	
	public DeplacementEntity(int id, String nomPatient, String prenomPatient, Date date, double cout, String nomInfirmiere, String prenomInfirmiere) {
		super();
		this.id = id;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.date = date;
		this.cout = cout;
		this.nomInfirmiere = nomInfirmiere;
		this.prenomInfirmiere = prenomInfirmiere;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getNomInfirmiere() {
		return nomInfirmiere;
	}

	public void setNomInfirmiere(String nomInfirmiere) {
		this.nomInfirmiere = nomInfirmiere;
	}

	public String getPrenomInfirmiere() {
		return prenomInfirmiere;
	}

	public void setPrenomInfirmiere(String prenomInfirmiere) {
		this.prenomInfirmiere = prenomInfirmiere;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getInfirmiere_id() {
		return infirmiere_id;
	}

	public void setInfirmiere_id(int infirmiere_id) {
		this.infirmiere_id = infirmiere_id;
	}
	
	
}