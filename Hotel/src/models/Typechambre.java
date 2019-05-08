package models;

public class Typechambre extends BaseModel {
		private String nomtype;
		private String imagetype;
		public String getNomtype() {
			return nomtype;
		}
		public void setNomtype(String nomtype) {
			this.nomtype = nomtype;
		}
		public String getImagetype() {
			return imagetype;
		}
		public void setImagetype(String imagetype) {
			this.imagetype = imagetype;
		}
}
