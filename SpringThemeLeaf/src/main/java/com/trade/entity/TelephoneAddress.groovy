/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.NamedQuery
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * The persistent class for the telephone_addresses database table.
 * 
 */
@Entity
@Table(name="telephone_addresses")
@NamedQuery(name="TelephoneAddress.findAll", query="SELECT t FROM TelephoneAddress t")
class TelephoneAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TelephoneAddressPK id;

	@Column(name="create_by")
	private String createBy;

	@Column(name="telephone_number")
	private String telephoneNumber;

	@Column(name="update_by")
	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_dtm")
	private Date updateDtm;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="id" , insertable = false, updatable = false)
	private Address address;

	public TelephoneAddress() {
	}

	public TelephoneAddressPK getId() {
		return this.id;
	}

	public void setId(TelephoneAddressPK id) {
		this.id = id;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDtm() {
		return this.updateDtm;
	}

	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}