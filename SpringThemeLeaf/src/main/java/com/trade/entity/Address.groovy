/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType



/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name="addresses")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name="create_by")
	private String createBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="update_by")
	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to AddressTypeCd
	@ManyToOne
	@JoinColumn(name="type_cd")
	private AddressTypeCd addressTypeCd;

	//bi-directional many-to-one association to ElectronicAddress
	@OneToMany(mappedBy="address")
	private List<ElectronicAddress> electronicAddresses;

	//bi-directional many-to-one association to PartyAddress
	@OneToMany(mappedBy="address")
	private List<PartyAddress> partyAddresses;

	//bi-directional many-to-one association to StreetAddress
	@OneToMany(mappedBy="address")
	private List<StreetAddress> streetAddresses;

	//bi-directional many-to-one association to TelephoneAddress
	@OneToMany(mappedBy="address")
	private List<TelephoneAddress> telephoneAddresses;

	public Address() {
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

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public AddressTypeCd getAddressTypeCd() {
		return this.addressTypeCd;
	}

	public void setAddressTypeCd(AddressTypeCd addressTypeCd) {
		this.addressTypeCd = addressTypeCd;
	}

	public List<ElectronicAddress> getElectronicAddresses() {
		return this.electronicAddresses;
	}

	public void setElectronicAddresses(List<ElectronicAddress> electronicAddresses) {
		this.electronicAddresses = electronicAddresses;
	}

	public ElectronicAddress addElectronicAddress(ElectronicAddress electronicAddress) {
		getElectronicAddresses().add(electronicAddress);
		electronicAddress.setAddress(this);

		return electronicAddress;
	}

	public ElectronicAddress removeElectronicAddress(ElectronicAddress electronicAddress) {
		getElectronicAddresses().remove(electronicAddress);
		electronicAddress.setAddress(null);

		return electronicAddress;
	}

	public List<PartyAddress> getPartyAddresses() {
		return this.partyAddresses;
	}

	public void setPartyAddresses(List<PartyAddress> partyAddresses) {
		this.partyAddresses = partyAddresses;
	}

	public PartyAddress addPartyAddress(PartyAddress partyAddress) {
		getPartyAddresses().add(partyAddress);
		partyAddress.setAddress(this);

		return partyAddress;
	}

	public PartyAddress removePartyAddress(PartyAddress partyAddress) {
		getPartyAddresses().remove(partyAddress);
		partyAddress.setAddress(null);

		return partyAddress;
	}

	public List<StreetAddress> getStreetAddresses() {
		return this.streetAddresses;
	}

	public void setStreetAddresses(List<StreetAddress> streetAddresses) {
		this.streetAddresses = streetAddresses;
	}

	public StreetAddress addStreetAddress(StreetAddress streetAddress) {
		getStreetAddresses().add(streetAddress);
		streetAddress.setAddress(this);

		return streetAddress;
	}

	public StreetAddress removeStreetAddress(StreetAddress streetAddress) {
		getStreetAddresses().remove(streetAddress);
		streetAddress.setAddress(null);

		return streetAddress;
	}

	public List<TelephoneAddress> getTelephoneAddresses() {
		return this.telephoneAddresses;
	}

	public void setTelephoneAddresses(List<TelephoneAddress> telephoneAddresses) {
		this.telephoneAddresses = telephoneAddresses;
	}

	public TelephoneAddress addTelephoneAddress(TelephoneAddress telephoneAddress) {
		getTelephoneAddresses().add(telephoneAddress);
		telephoneAddress.setAddress(this);

		return telephoneAddress;
	}

	public TelephoneAddress removeTelephoneAddress(TelephoneAddress telephoneAddress) {
		getTelephoneAddresses().remove(telephoneAddress);
		telephoneAddress.setAddress(null);

		return telephoneAddress;
	}

}