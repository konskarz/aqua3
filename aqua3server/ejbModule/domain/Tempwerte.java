package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEMPWERTE")
public class Tempwerte extends VonBisWerte {

	private static final long serialVersionUID = 1L;
	private Long tempwerteId;

	public Tempwerte() {}

	@Id @GeneratedValue
	@Column(name="TEMPWERTE_ID")
	public Long getTempwerteId() {return this.tempwerteId;}
	public void setTempwerteId(Long tempwerteId) {this.tempwerteId = tempwerteId;}

}
