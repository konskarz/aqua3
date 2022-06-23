package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SZENARIEN_FUTTERZEITEN")
public class SzenarienFutterzeiten implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long futterzeitenId;
	private String uhrzeit;

	public SzenarienFutterzeiten() {}

	@Id @GeneratedValue
	@Column(name="FUTTERZEITEN_ID")
	public Long getSzenarienId() {return futterzeitenId;}
	public void setSzenarienId(Long szenarienId) {this.futterzeitenId = szenarienId;}

	@Column(name="UHRZEIT", length=5, nullable=false)
	public String getUhrzeit() {return uhrzeit;}
	public void setUhrzeit(String zeit) {this.uhrzeit = zeit;}

	public String toString() {
		return getUhrzeit();
	}

}
