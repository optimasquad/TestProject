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
 * The persistent class for the party_addresses database table.
 * 
 */
@Entity
@Table(name="party_addresses")
@NamedQuery(name="PartyAddress.findAll", query="SELECT p FROM PartyAddress p")
class PartyAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartyAddressPK id;

	@Column(name="create_by")
	private String createBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_dtm")
	private Date createDtm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="update_by")
	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_dtm")
	private Date updateDtm;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Address address;

	//bi-directional many-to-one association to Party
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Party party;

	public PartyAddress() {
	}

	public PartyAddressPK getId() {
		return this.id;
	}

	public void setId(PartyAddressPK id) {
		this.id = id;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDtm() {
		return this.createDtm;
	}

	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}