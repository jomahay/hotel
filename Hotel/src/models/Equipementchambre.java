package models;

public class Equipementchambre extends BaseModel {
		private int idchambre;
		private int idequipement;
		private int nombre;
		public int getIdchambre() {
			return idchambre;
		}
		public void setIdchambre(int idchambre) {
			this.idchambre = idchambre;
		}
		public int getIdequipement() {
			return idequipement;
		}
		public void setIdequipement(int idequipement) {
			this.idequipement = idequipement;
		}
		public int getNombre() {
			return nombre;
		}
		public void setNombre(int nombre) {
			this.nombre = nombre;
		}
}
