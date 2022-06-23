package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHWERTE")
public class Phwerte extends VonBisWerte {

	private static final long serialVersionUID = 1L;
	private Long phwerteId;

	public Phwerte() {}

	@Id @GeneratedValue
	@Column(name="PHWERTE_ID")
	public Long getPhwerteId() {return this.phwerteId;}
	public void setPhwerteId(Long phwerteId) {this.phwerteId = phwerteId;}

}
