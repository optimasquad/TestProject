/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType



/**
 * The persistent class for the parties database table.
 * 
 */
@Entity
@Table(name="parties")
@NamedQuery(name="Party.findAll", query="SELECT p FROM Party p")
class Party implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name="create_by")
	private String createBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_dtm")
	private Date createDtm;

	@Column(name="type_cd")
	private String typeCd;

	@Column(name="update_by")
	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_dtm")
	private Date updateDtm;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to PartyAddress
	@OneToMany(mappedBy="party")
	private List<PartyAddress> partyAddresses;

	//bi-directional many-to-one association to PartyName
	@OneToMany(mappedBy="party")
	private List<PartyName> partyNames;



	public Party() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getTypeCd() {
		return this.typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<PartyAddress> getPartyAddresses() {
		return this.partyAddresses;
	}

	public void setPartyAddresses(List<PartyAddress> partyAddresses) {
		this.partyAddresses = partyAddresses;
	}

	public PartyAddress addPartyAddress(PartyAddress partyAddress) {
		getPartyAddresses().add(partyAddress);
		partyAddress.setParty(this);

		return partyAddress;
	}

	public PartyAddress removePartyAddress(PartyAddress partyAddress) {
		getPartyAddresses().remove(partyAddress);
		partyAddress.setParty(null);

		return partyAddress;
	}

	public List<PartyName> getPartyNames() {
		return this.partyNames;
	}

	public void setPartyNames(List<PartyName> partyNames) {
		this.partyNames = partyNames;
	}

	public PartyName addPartyName(PartyName partyName) {
		getPartyNames().add(partyName);
		partyName.setParty(this);

		return partyName;
	}

	public PartyName removePartyName(PartyName partyName) {
		getPartyNames().remove(partyName);
		partyName.setParty(null);

		return partyName;
	}



}