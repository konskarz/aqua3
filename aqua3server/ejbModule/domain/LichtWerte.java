package domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.swing.SpinnerModel;

@Embeddable
public class LichtWerte implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String lichtein;
	private String lichtaus;
	public static final String PATTERN = "HH:mm";
	private final SimpleDateFormat FORMATER = new SimpleDateFormat(PATTERN);

	public LichtWerte() {}

	@Column(name="LICHTEIN", length=5, nullable=false)
	public String getLichtein() {return lichtein;}
	public void setLichtein(String lichtein) {this.lichtein = lichtein;}

	@Column(name="LICHTAUS", length=5, nullable=false)
	public String getLichtaus() {return lichtaus;}
	public void setLichtaus(String lichtaus) {this.lichtaus = lichtaus;}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void refreshWerte(SpinnerModel[] models) {
		try {
			models[0].setValue(FORMATER.parse(lichtein));
			models[1].setValue(FORMATER.parse(lichtaus));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveWerte(SpinnerModel[] models) {
		lichtein = FORMATER.format((Date)models[0].getValue());
		lichtaus = FORMATER.format((Date)models[1].getValue());
	}

}
