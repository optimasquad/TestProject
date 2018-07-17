/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Temporal
import javax.persistence.TemporalType


/**
 * The primary key class for the party_addresses database table.
 * 
 */
@Embeddable
public class PartyAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="party_id", insertable=false, updatable=false)
	private int partyId;

	@Column(name="address_id", insertable=false, updatable=false)
	private int addressId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private java.util.Date startDate;

	public PartyAddressPK() {
	}
	public int getPartyId() {
		return this.partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public int getAddressId() {
		return this.addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartyAddressPK)) {
			return false;
		}
		PartyAddressPK castOther = (PartyAddressPK)other;
		return
		(this.partyId == castOther.partyId)
		and (this.addressId == castOther.addressId)
		and this.startDate.equals(castOther.startDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.partyId;
		hash = hash * prime + this.addressId;
		hash = hash * prime + this.startDate.hashCode();

		return hash;
	}
}