/**
 * 
 */
package com.trade.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.Table


/**
 * The persistent class for the address_type_cd database table.
 * 
 */
@Entity
@Table(name="address_type_cd")
@NamedQuery(name="AddressTypeCd.findAll", query="SELECT a FROM AddressTypeCd a")
class AddressTypeCd implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "type_cd", unique = true, nullable = false)
	private String type_cd;

	private String description;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="addressTypeCd")
	private List<Address> addresses;

	public AddressTypeCd() {
	}

	public String getType_cd() {
		return this.type_cd;
	}

	public void setType_cd(String type_cd) {
		this.type_cd = type_cd;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setAddressTypeCd(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setAddressTypeCd(null);

		return address;
	}

}