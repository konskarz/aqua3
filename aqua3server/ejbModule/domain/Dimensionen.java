package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.SpinnerModel;

@Entity
@Table(name="DIMENSIONEN")
public class Dimensionen implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private Long dimensionenId;
	private int laenge;
	private int breite;
	private int hoehe;
	private int volumen;

	public Dimensionen() {}

	@Id @GeneratedValue
	@Column(name="DIMENSIONEN_ID")
	public Long getDimensionenId() {return this.dimensionenId;}
	public void setDimensionenId(Long dimensionenId) {this.dimensionenId = dimensionenId;}

	@Column(name="LAENGE")
	public int getLaenge() {return this.laenge;}
	public void setLaenge(int laenge) {this.laenge = laenge;}

	@Column(name="BREITE")
	public int getBreite() {return this.breite;}
	public void setBreite(int breite) {this.breite = breite;}

	@Column(name="HOEHE")
	public int getHoehe() {return this.hoehe;}
	public void setHoehe(int hoehe) {this.hoehe = hoehe;}

	@Column(name="VOLUMEN")
	public int getVolumen() {return this.volumen;}
	public void setVolumen(int volumen) {this.volumen = volumen;}
	
	public String toString() {
		return laenge+"x"+breite+"x"+hoehe;
	}

	@Override
	public Dimensionen clone() throws CloneNotSupportedException {
		Dimensionen d = (Dimensionen) super.clone();
		d.dimensionenId = null;
		return d;
	}

	public void refreshWerte(SpinnerModel[] models) {
		models[0].setValue(laenge);
		models[1].setValue(breite);
		models[2].setValue(hoehe);
	}

	public void saveWerte(SpinnerModel[] models) {
		laenge = Integer.parseInt(models[0].getValue().toString());
		breite = Integer.parseInt(models[1].getValue().toString());
		hoehe = Integer.parseInt(models[2].getValue().toString());
		volumen = laenge*breite*hoehe/1000;
	}

}
