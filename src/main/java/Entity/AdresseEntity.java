package Entity;

public class AdresseEntity {
	
	private String numero;
	private String rue;
	private int cp;
	private String ville;
	private int id;
	
	public AdresseEntity(int id, String numero, String rue, int cp, String ville) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
