package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TYPEN")
public class Typen implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long typenId;
	private String bezeichnung;
//	private int brauchttemp;
//	private int brauchtph;
//	private String sozialverhalten;
//	private String kantenab;
//	private String einheittxt;

	public Typen() {}

	@Id @GeneratedValue
	@Column(name="TYPEN_ID")
	public Long getTypenId() {return typenId;}
	public void setTypenId(Long typenId) {this.typenId = typenId;}

	@Column(name = "BEZEICHNUNG", length=50, nullable=false)
	public String getBezeichnung() {return bezeichnung;}
	public void setBezeichnung(String bezeichnung) {this.bezeichnung = bezeichnung;}

	public boolean isOfTheSameTyp(Typen typen) {
		return (this.getBezeichnung()).equals(typen.getBezeichnung());
	}
	
	public boolean isTheOfSameTyp(Typen typen) {
		return this.bezeichnung.equals(typen.bezeichnung);
	}

	public String toString() {
		return this.getBezeichnung();
	}

//	@Column(name="BRAUCHTTEMP", nullable=false)
//	public int getBrauchttemp() {return brauchttemp;}
//	public void setBrauchttemp(int brauchttemp) {this.brauchttemp = brauchttemp;}
//
//	@Column(name="BRAUCHTPH", nullable=false)
//	public int getBrauchtph() {return brauchtph;}
//	public void setBrauchtph(int brauchtph) {this.brauchtph = brauchtph;}
//
//	@Column(name="SOZIALVERHALTEN")
//	public String getSozialverhalten() {return sozialverhalten;}
//	public void setSozialverhalten(String sozialverhalten) {this.sozialverhalten = sozialverhalten;}
//
//	@Column(name="KANTENAB")
//	public String getKantenab() {return kantenab;}
//	public void setKantenab(String kantenab) {this.kantenab = kantenab;}
//
//	@Column(name="EINHEITTXT")
//	public String getEinheittxt() {return einheittxt;}
//	public void setEinheittxt(String einheittxt) {this.einheittxt = einheittxt;}
//
}
