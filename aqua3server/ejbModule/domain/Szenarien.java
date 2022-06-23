package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="SZENARIEN")
public class Szenarien implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private Long szenarienId;
	private String name;
	private String shortname;
	private VonBisWerte tempWerte;
	private VonBisWerte phWerte;
	private LichtWerte lichtWerte;
	private Dimensionen dimensionen;
	private List<SzenarienFutterzeiten> szenarienFutterzeiten = new ArrayList<SzenarienFutterzeiten>();
	private Set<SzenarienLebewesen> szenarienLebewesen = new HashSet<SzenarienLebewesen>();

	public Szenarien() {}

	@Id @GeneratedValue
	@Column(name="SZENARIEN_ID")
	public Long getSzenarienId() {return this.szenarienId;}
	public void setSzenarienId(Long szenarienId) {this.szenarienId = szenarienId;}

	@Column(name="NAME", nullable=false)
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}

	@Column(name="SHORTNAME", length=6, nullable=false)
	public String getShortname() {return this.shortname;}
	public void setShortname(String shortname) {this.shortname = shortname;}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="von", column=@Column(name="TEMPMIN", nullable=false)),
		@AttributeOverride(name="bis", column=@Column(name="TEMPMAX", nullable=false))
		})
	public VonBisWerte getTempWerte( ) {return tempWerte;}
	public void setTempWerte(VonBisWerte tempWerte) {this.tempWerte = tempWerte;}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="von", column=@Column(name="PHMIN", nullable=false)),
		@AttributeOverride(name="bis", column=@Column(name="PHMAX", nullable=false))
		})
	public VonBisWerte getPhWerte() {return phWerte;}
	public void setPhWerte(VonBisWerte phWerte) {this.phWerte = phWerte;}

	@Embedded
	public LichtWerte getLichtWerte() {return lichtWerte;}
	public void setLichtWerte(LichtWerte lichtWerte) {this.lichtWerte = lichtWerte;}

	@OneToOne
	@JoinColumn(name="DIMENSIONEN_ID", nullable=false)
	public Dimensionen getDimensionen() {return this.dimensionen;}
	public void setDimensionen(Dimensionen dimensionen) {this.dimensionen = dimensionen;}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name = "SZENARIEN_ID", nullable=false)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@Fetch(FetchMode.SUBSELECT)
	public List<SzenarienFutterzeiten> getSzenarienFutterzeiten() {return szenarienFutterzeiten;}
	public void setSzenarienFutterzeiten(List<SzenarienFutterzeiten> szenarienFutterzeiten) {this.szenarienFutterzeiten = szenarienFutterzeiten;}

	@OneToMany(mappedBy="szenarien", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@Fetch(FetchMode.SUBSELECT)
	public Set<SzenarienLebewesen> getSzenarienLebewesen() {return szenarienLebewesen;}
	public void setSzenarienLebewesen(Set<SzenarienLebewesen> szenarienLebewesen) {this.szenarienLebewesen = szenarienLebewesen;}

	public void saveName(String newName) {
		if(newName.length()>0) {
			this.name = newName;
			this.shortname = name.length()>6 ? name.substring(0,6) : name;
		}
	}

	@Override
	public Szenarien clone() throws CloneNotSupportedException {
		Szenarien s = (Szenarien)super.clone();
		if(this.tempWerte!=null)
			s.tempWerte = (VonBisWerte) this.tempWerte.clone();
		if(this.phWerte!=null)
			s.phWerte = (VonBisWerte) this.phWerte.clone();
		if(this.lichtWerte!=null)
			s.lichtWerte = (LichtWerte) this.lichtWerte.clone();
		s.szenarienFutterzeiten = new ArrayList<SzenarienFutterzeiten>();
		s.szenarienLebewesen = new HashSet<SzenarienLebewesen>();
		s.szenarienId = null;
		return s;
	}

	@Override
	public String toString() {
		return getName();
	}

}
