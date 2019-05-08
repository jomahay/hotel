package models;

public class Chambreview extends BaseModel {
	private String nomchambre;
	private String nomtype;
	private int prix;
	private String description;
	private int nombrepersonne;
	private String imagechambre;
	private String nomequipement;
	private int nombreequipement;
	public String getNomchambre() {
		return nomchambre;
	}
	public void setNomchambre(String nomchambre) {
		this.nomchambre = nomchambre;
	}
	public String getNomtype() {
		return nomtype;
	}
	public void setNomtype(String nomtype) {
		this.nomtype = nomtype;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNombrepersonne() {
		return nombrepersonne;
	}
	public void setNombrepersonne(int nombrepersonne) {
		this.nombrepersonne = nombrepersonne;
	}
	public String getImagechambre() {
		return imagechambre;
	}
	public void setImagechambre(String imagechambre) {
		this.imagechambre = imagechambre;
	}
	public String getNomequipement() {
		return nomequipement;
	}
	public void setNomequipement(String nomequipement) {
		this.nomequipement = nomequipement;
	}
	public int getNombreequipement() {
		return nombreequipement;
	}
	public void setNombreequipement(int nombreequipement) {
		this.nombreequipement = nombreequipement;
	}
}
