package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.swing.SpinnerModel;

@Embeddable
@MappedSuperclass
public class VonBisWerte implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private double von;
	private double bis;

	public VonBisWerte() {}

	@Column(name="VON", nullable=false)
	public double getVon() {return von;}
	public void setVon(double von) {this.von = von;}

	@Column(name="BIS", nullable=false)
	public double getBis() {return bis;}
	public void setBis(double bis) {this.bis = bis;}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void refreshWerte(SpinnerModel[] models) {
		models[0].setValue(getVon());
		models[1].setValue(getBis());
	}

	public void saveWerte(SpinnerModel[] models) {
		double newVon = Double.parseDouble(models[0].getValue().toString());
		double newBis = Double.parseDouble(models[1].getValue().toString());
		if(newVon<newBis) {
			setVon(newVon);
			setBis(newBis);
		}
	}

}
