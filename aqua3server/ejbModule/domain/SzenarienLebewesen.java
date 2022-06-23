package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SZENARIEN_LEBEWESEN")
//@PrimaryKeyJoinColumn(name="LEBEWESEN_ID")
public class SzenarienLebewesen implements Serializable {// extends Lebewesen {

	private static final long serialVersionUID = 1L;
	private SzenarienLebewesenId szenarienLebewesenId = new SzenarienLebewesenId();
	private int lebewesenmenge;
	private Lebewesen lebewesen;
	private Szenarien szenarien;
	
	public SzenarienLebewesen() {}

	public SzenarienLebewesen(Szenarien szenarien, Lebewesen lebewesen, int menge) {
		this.lebewesenmenge = menge;
		this.lebewesen = lebewesen;
		this.szenarien = szenarien;
		this.szenarienLebewesenId.szenarienId = szenarien.getSzenarienId();
		this.szenarienLebewesenId.lebewesenId = lebewesen.getLebewesenId();
	}

	@EmbeddedId
	public SzenarienLebewesenId getSzenarienLebewesenId() {return szenarienLebewesenId;}
	public void setSzenarienLebewesenId(SzenarienLebewesenId szenarienLebewesenId) {this.szenarienLebewesenId = szenarienLebewesenId;}

	@Column(name = "LEBEWESENMENGE", nullable = false)
	public int getLebewesenmenge() {return this.lebewesenmenge;}
	public void setLebewesenmenge(int lebewesenmenge) {this.lebewesenmenge = lebewesenmenge;}

	@ManyToOne
	@JoinColumn(name="LEBEWESEN_ID", nullable = false, insertable = false, updatable = false)
	public Lebewesen getLebewesen() {return lebewesen;}
	public void setLebewesen(Lebewesen lebewesen) {this.lebewesen = lebewesen;}

	@ManyToOne
	@JoinColumn(name="SZENARIEN_ID", nullable = false, insertable = false, updatable = false)
	public Szenarien getSzenarien() {return szenarien;}
	public void setSzenarien(Szenarien szenarien) {this.szenarien = szenarien;}

	public void updateMenge(int menge) {
		setLebewesenmenge(getLebewesenmenge() + menge);
	}

	public boolean isTheSame(Lebewesen lw) {
		return this.getLebewesen().isTheSame(lw);
	}

	@Override
	public String toString() {
		return getLebewesen()+" ("+getLebewesenmenge()+")";
	}

	@Embeddable
	public static class SzenarienLebewesenId implements Serializable {
		private static final long serialVersionUID = 1L;
		private Long szenarienId;
		private Long lebewesenId;

		public SzenarienLebewesenId() {}
		
		public SzenarienLebewesenId(Long szenarienId, Long lebewesenId) {
			this.szenarienId = szenarienId;
			this.lebewesenId = lebewesenId;
		}
		
		@Column(name = "SZENARIEN_ID")
		public Long getSzenarienId() {return szenarienId;}
		public void setSzenarienId(Long szenarienId) {this.szenarienId = szenarienId;}

		@Column(name = "LEBEWESEN_ID")
		public Long getLebewesenId() {return lebewesenId;}
		public void setLebewesenId(Long lebewesenId) {this.lebewesenId = lebewesenId;}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((lebewesenId == null) ? 0 : lebewesenId.hashCode());
			result = prime * result
					+ ((szenarienId == null) ? 0 : szenarienId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final SzenarienLebewesenId other = (SzenarienLebewesenId) obj;
			if (lebewesenId == null) {
				if (other.lebewesenId != null)
					return false;
			} else if (!lebewesenId.equals(other.lebewesenId))
				return false;
			if (szenarienId == null) {
				if (other.szenarienId != null)
					return false;
			} else if (!szenarienId.equals(other.szenarienId))
				return false;
			return true;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lebewesenmenge;
		result = prime
				* result
				+ ((szenarienLebewesenId == null) ? 0 : szenarienLebewesenId
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SzenarienLebewesen other = (SzenarienLebewesen) obj;
		if (lebewesenmenge != other.lebewesenmenge)
			return false;
		if (szenarienLebewesenId == null) {
			if (other.szenarienLebewesenId != null)
				return false;
		} else if (!szenarienLebewesenId.equals(other.szenarienLebewesenId))
			return false;
		return true;
	}

}
