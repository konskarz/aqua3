package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LEBEWESEN")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Lebewesen implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long lebewesenId;
	private String name;
	private String info;
	private String photo;
	private int kantenab;
	private Tempwerte tempwerte;
	private Phwerte phwerte;
	private Typen typen;

	public Lebewesen() {}

	@Id @GeneratedValue
	@Column(name="LEBEWESEN_ID")
	public Long getLebewesenId() {return this.lebewesenId;}
	public void setLebewesenId(Long lebewesenId) {this.lebewesenId = lebewesenId;}

	@Column(name="NAME", length=150, nullable=false)
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}

	@Column(name="INFO")
	public String getInfo() {return this.info;}
	public void setInfo(String info) {this.info = info;}

	@Column(name="PHOTO", length=150)
	public String getPhoto() {return this.photo;}
	public void setPhoto(String photo) {this.photo = photo;}

	@Column(name="KANTENAB")
	public int getKantenab() {return this.kantenab;}
	public void setKantenab(int kantenab) {this.kantenab = kantenab;}

	@OneToOne
	@JoinColumn(name = "TEMPWERTE_ID")
	public Tempwerte getTempwerte() {return this.tempwerte;}
	public void setTempwerte(Tempwerte tempwerte) {this.tempwerte = tempwerte;}

	@OneToOne
	@JoinColumn(name = "PHWERTE_ID")
	public Phwerte getPhwerte() {return this.phwerte;}
	public void setPhwerte(Phwerte phwerte) {this.phwerte = phwerte;}

	@ManyToOne
	@JoinColumn(name = "TYPEN_ID", nullable=false)
	public Typen getTypen() {return typen;}
	public void setTypen(Typen typen) {this.typen = typen;}
	
	public boolean isOfTheSameTyp(Lebewesen l) {
		return this.getTypen().isTheOfSameTyp(l.getTypen());
	}

	public boolean isTheSame(Lebewesen lw) {
		return this.getName().equals(lw.getName());
	}

	@Override
	public String toString() {
		return this.name;
	}

}
