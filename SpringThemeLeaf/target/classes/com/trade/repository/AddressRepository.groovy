/**
 * 
 */
package com.trade.repository

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.trade.entity.Address
import com.trade.entity.Banner

/**
 * @author jatin
 *
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	//retrieving the Type code from the Address Id i.e. is whether it is the telephoneAddress/ElectronicAddress or is the StreetAddress
	@Query("select ad.id from Address ad where ad.id=:address_id and ad.addressTypeCd.type_cd=:type_cd and ad.id.startDate<=:current_date and ad.endDate>=:end_date")
	long validate_address_id(@Param("address_id")String address_id,@Param("end_date")Date endDate,@Param("current_date")Date currentDate,@Param("type_cd")String type_cd);

}
