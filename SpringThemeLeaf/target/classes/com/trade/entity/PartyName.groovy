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
 * The persistent class for the party_names database table.
 * 
 */
@Entity
@Table(name="party_names")
@NamedQuery(name="PartyName.findAll", query="SELECT p FROM PartyName p")
public class PartyName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartyNamePK id;

	@Column(name="date_of_birth")
	private String dateOfBirth;

	@Column(name="father_first_name")
	private String fatherFirstName;

	@Column(name="father_last_name")
	private String fatherLastName;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_dtm")
	private Date updateDtm;

	//bi-directional many-to-one association to Party
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Party party;

	public PartyName() {
	}

	public PartyNamePK getId() {
		return this.id;
	}

	public void setId(PartyNamePK id) {
		this.id = id;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherFirstName() {
		return this.fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherLastName() {
		return this.fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getUpdateDtm() {
		return this.updateDtm;
	}

	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}