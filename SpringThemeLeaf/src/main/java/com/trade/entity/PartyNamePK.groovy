/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Temporal
import javax.persistence.TemporalType


/**
 * The primary key class for the party_names database table.
 * 
 */
@Embeddable
class PartyNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="party_id", insertable=false, updatable=false)
	private int partyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_dtm")
	private java.util.Date createDtm;

	public PartyNamePK() {
	}
	public int getPartyId() {
		return this.partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public java.util.Date getCreateDtm() {
		return this.createDtm;
	}
	public void setCreateDtm(java.util.Date createDtm) {
		this.createDtm = createDtm;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartyNamePK)) {
			return false;
		}
		PartyNamePK castOther = (PartyNamePK)other;
		return 
			(this.partyId == castOther.partyId)
			and this.createDtm.equals(castOther.createDtm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.partyId;
		hash = hash * prime + this.createDtm.hashCode();
		
		return hash;
	}
}