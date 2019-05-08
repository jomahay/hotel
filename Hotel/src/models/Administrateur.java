package models;

public class Administrateur extends BaseModel {
	public Administrateur() {
		super();
	}
	public Administrateur(Integer id, String nom, String mdpadmin) {
		super(id);
		this.nom = nom;
		this.mdpadmin = mdpadmin;
	}
	private String nom;
	private String mdpadmin;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMdpadmin() {
		return mdpadmin;
	}
	public void setMdpadmin(String mdpadmin) {
		this.mdpadmin = mdpadmin;
	}
}
