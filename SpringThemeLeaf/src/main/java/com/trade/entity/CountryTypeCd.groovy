package com.trade.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.Table


/**
 * The persistent class for the country_type_cd database table.
 * 
 */
@Entity
@Table(name="country_type_cd")
@NamedQuery(name="CountryTypeCd.findAll", query="SELECT c FROM CountryTypeCd c")
class CountryTypeCd implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="type_cd" , unique = true, nullable = false)
	private String typeCd;

	private String description;

	//bi-directional many-to-one association to StreetAddress
	@OneToMany(mappedBy="countryTypeCdBean")
	private List<StreetAddress> streetAddresses;

	public CountryTypeCd() {
	}

	public String getTypeCd() {
		return this.typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<StreetAddress> getStreetAddresses() {
		return this.streetAddresses;
	}

	public void setStreetAddresses(List<StreetAddress> streetAddresses) {
		this.streetAddresses = streetAddresses;
	}

	public StreetAddress addStreetAddress(StreetAddress streetAddress) {
		getStreetAddresses().add(streetAddress);
		streetAddress.setCountryTypeCdBean(this);

		return streetAddress;
	}

	public StreetAddress removeStreetAddress(StreetAddress streetAddress) {
		getStreetAddresses().remove(streetAddress);
		streetAddress.setCountryTypeCdBean(null);

		return streetAddress;
	}

}