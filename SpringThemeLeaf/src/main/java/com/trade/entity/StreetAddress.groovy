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
 * The persistent class for the street_addresses database table.
 * 
 */
@Entity
@Table(name="street_addresses")
@NamedQuery(name="StreetAddress.findAll", query="SELECT s FROM StreetAddress s")
class StreetAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StreetAddressPK id;

	@Column(name="address_line_1")
	private String addressLine1;

	@Column(name="address_line_2")
	private String addressLine2;

	@Column(name="address_line_3")
	private String addressLine3;

	private String city;

	@Column(name="create_by")
	private String createBy;

	@Column(name="post_code")
	private String postCode;

	@Column(name="update_by")
	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_dtm")
	private Date updateDtm;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Address address;

	//bi-directional many-to-one association to CountryTypeCd
	@ManyToOne
	@JoinColumn(name="country_type_cd" , insertable = false, updatable = false)
	private CountryTypeCd countryTypeCdBean;

	public StreetAddress() {
	}

	public StreetAddressPK getId() {
		return this.id;
	}

	public void setId(StreetAddressPK id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public CountryTypeCd getCountryTypeCdBean() {
		return this.countryTypeCdBean;
	}

	public void setCountryTypeCdBean(CountryTypeCd countryTypeCdBean) {
		this.countryTypeCdBean = countryTypeCdBean;
	}

}