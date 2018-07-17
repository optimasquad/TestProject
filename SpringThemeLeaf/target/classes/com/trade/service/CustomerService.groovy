/**
 * 
 */
package com.trade.service
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.trade.common.Tradeconstants
import com.trade.entity.Party
import com.trade.helper.UtilityHelper
import com.trade.model.UserRegistrationBean
import com.trade.repository.AddressRepository
import com.trade.repository.CustomerUserRepository
import com.trade.repository.ElectronicAddressRepository
import com.trade.repository.TelephoneAddressRepository

/**
 * @author jatin
 *
 */
@Service
@Transactional
class CustomerService {

	//This is the service class to save the customer details

	static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerService.class)

	@Autowired
	CustomerUserRepository customerUserRepository;

	@Autowired
	ElectronicAddressRepository electronicAddressRepository;

	@Autowired
	TelephoneAddressRepository telephoneAddressRepository;

	@Autowired
	AddressRepository addressRepository


	@Transactional
	public UserRegistrationBean saveCustomer(UserRegistrationBean userRegistrationBean) {
		try{
			logger.info "Save customer and validate  entered::"
			/*We need to check that if the username and
			 email address exists for some other customer/not at the DAO layer*/

			/*	Basically CreateBy must be the user ipAddress.
			 * 
			 * This still need to be captured*/

			//	userRegistrationBean userRegistrationBean=userRegistrationDao.validateDetails(username, emailAddress,phoneNumber);



			//Calling the Repository to validate the details

			//Step 1-Validating the Username
			//Step 2-Validating the emailAddres
			//Step 3-Validating the phoneNumber

			Party party=customerUserRepository.findByUserName(userRegistrationBean.getUserName())
			if(party && 0!=party.getId() ){
				//This means the username exists and setting the username flag as true

				userRegistrationBean.setUserName(true)
			}
			if(!userRegistrationBean){
				//validating the emailAddress
				List<Long> addressidList=electronicAddressRepository.validateElectronicAddress(userRegistrationBean.getEmailAddress())
				if(null!=addressidList && !addressidList.isEmpty()){

					for(long addressId:addressidList){
						long address_id=addressRepository.validate_address_id(addressId,UtilityHelper.getLastDate(),UtilityHelper.getDate(),Tradeconstants.EMAIL_ADDRESS_CONSTANT);
						//This means the emailAddress already exists and setting the emailAddress flag as true
						if(0!=address_id){
							userRegistrationBean.setEmail(true)
							break;
						}

					}
				}
			}
			if(null!=userRegistrationBean){

				//Now is to validate the phone number
				if(null!=userRegistrationBean.getPhoneNumber()){
					long id=telephoneAddressRepository.validate_telephone_address(userRegistrationBean.getPhoneNumber())

					if(0!=id){
						//This means the username exists and setting the username flag as true
						userRegistrationBean.setPhoneNumber(true)
					}

				}
			}
			if (null!=userRegistrationBean) {

				/*if(userRegistrationBean.isUserName)
				 {
				 logger.info "Save customer entered::"
				 }
				 else if(userRegistrationBean.isPhoneNumber)
				 {
				 logger.info "Save customer entered::"
				 }
				 else if(userRegistrationBean.isEmail)
				 {
				 logger.info "Save customer entered::"
				 }
				 } else {*/
				// Save in user table then in authorities table then in the
				party = new Party(userName: "helloboy1",typeCd:Tradeconstants.CREATE_USER,updateDtm:UtilityHelper.getDate(),createDtm:UtilityHelper.getDate(),
				createBy:"1111",updateBy:"1111");
				party = customerUserRepository.save(party)
				logger.info "After saving user and userdetails and authority ${party.id}"

				def id=" ${party.id}"
				//def id1=party['@id']
				userRegistrationBean.setUserId(id.toLong());

			}
		}
		catch(Exception e){
			logger.error("Error has occurred while registering the customer"+e.getMessage()+e.printStackTrace())
		}
		//logger.info "After saving user and userdetails and authority"+ userRegistrationBean.get

		return userRegistrationBean;
	}
}