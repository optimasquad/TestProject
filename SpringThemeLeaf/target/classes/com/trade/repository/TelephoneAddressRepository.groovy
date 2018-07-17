package com.trade.repository


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.trade.entity.TelephoneAddress

@Repository
public interface TelephoneAddressRepository extends JpaRepository<TelephoneAddress, Long> {
	//We have got the Address Id and now to be passed to the EmailAddress to retrieve the Data
	@Query("select tlead.telephoneNumber from TelephoneAddress tlead where tlead.id.addressId=:address_id")
	String select_telephone_address(@Param("address_id")String address_id);


	//We have got the Address Id and now to be passed to the EmailAddress to retrieve the Data
	@Query("select tlead.id.addressId from TelephoneAddress tlead where tlead.telephoneNumber=:telephone_number")
	String validate_telephone_address(@Param("telephone_number")String telephone_number);



}
