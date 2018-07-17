/**
 * 
 */
package com.trade.model

import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.NotEmpty

/**
 * @author jatin
 *
 */
class UserRegistrationBean implements Serializable {


	private String firstName;


	private String lastName;


	private String dateOfBirth;


	private String emailAddress;


	private String phoneNumber;



	private String password;


	private String userName;

	private boolean isUserName;

	private boolean isEmail;

	private boolean isPhoneNumber;

	private long userId;





	/**
	 * @return the isUserName
	 */
	public boolean isUserName() {
		return isUserName;
	}




	/**
	 * @param isUserName the isUserName to set
	 */
	public void setUserName(boolean isUserName) {
		this.isUserName = isUserName;
	}




	/**
	 * @return the isEmail
	 */
	public boolean isEmail() {
		return isEmail;
	}




	/**
	 * @param isEmail the isEmail to set
	 */
	public void setEmail(boolean isEmail) {
		this.isEmail = isEmail;
	}




	/**
	 * @return the isPhoneNumber
	 */
	public boolean isPhoneNumber() {
		return isPhoneNumber;
	}




	/**
	 * @param isPhoneNumber the isPhoneNumber to set
	 */
	public void setPhoneNumber(boolean isPhoneNumber) {
		this.isPhoneNumber = isPhoneNumber;
	}




	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}




	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}




	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserRegistrationBean{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", userName='" + userName + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
