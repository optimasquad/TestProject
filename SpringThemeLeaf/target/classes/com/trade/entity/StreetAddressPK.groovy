/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Temporal
import javax.persistence.TemporalType


/**
 * @author jatin
 *
 */
@Embeddable
class StreetAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="address_id", insertable=false, updatable=false)
	private int addressId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_dtm")
	private java.util.Date createDtm;

	public StreetAddressPK() {
	}
	public int getAddressId() {
		return this.addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
		if (!(other instanceof StreetAddressPK)) {
			return false;
		}
		StreetAddressPK castOther = (StreetAddressPK)other;
		return 
			(this.addressId == castOther.addressId)
			and this.createDtm.equals(castOther.createDtm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.addressId;
		hash = hash * prime + this.createDtm.hashCode();
		
		return hash;
	}
}