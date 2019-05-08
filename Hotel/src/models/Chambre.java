package models;

import java.util.Date;

public class Chambre extends BaseModel {
	private String nomchambre;
	private int prix;
	private int idtype;
	private String description;
	private int nombrepersonne;
	private String imagechambre;
	public String getNomchambre() {
		return nomchambre;
	}
	public void setNomchambre(String nomchambre) {
		this.nomchambre = nomchambre;
	}
	public int getPrix() {
		return prix;
	}
	public Chambre() {
		super();
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Chambre(Integer id, String nomchambre, int prix, int idtype, String description,
			int nombrepersonne, String imagechambre) {
		super(id);
		this.nomchambre = nomchambre;
		this.prix = prix;
		
		this.idtype = idtype;
		this.description = description;
		this.nombrepersonne = nombrepersonne;
		this.imagechambre = imagechambre;
	}
	
	public int getIdtype() {
		return idtype;
	}
	public void setIdtype(int idtype) {
		this.idtype = idtype;
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
}
