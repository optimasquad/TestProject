package com.trade.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.trade.entity.Address
import com.trade.entity.ElectronicAddress
import com.trade.entity.ElectronicAddressPK
import com.trade.entity.PartyAddress

@Repository
public interface ElectronicAddressRepository extends JpaRepository<ElectronicAddress, Long> {

	//We have got the Address Id and now to be passed to the EmailAddress to retrieve the Data
	@Query("select ead.id.emailAddress from ElectronicAddress ead where ead.id.addressId=:address_id")
	String Select_email_address(@Param("address_id")String address_id);

	@Query("select ead.id.addressId from ElectronicAddress ead where ead.id.emailAddress=:email_address")
	List<Long> validateElectronicAddress(@Param("email_address")String email_address);


}
