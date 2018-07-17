/**
 * 
 */
package com.trade.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.trade.entity.PartyAddress

/**
 * @author jatin
 *
 */
@Repository
public interface PartyAddressRepository extends JpaRepository<PartyAddress, Long> {
	@Query("select pad.id.addressId from PartyAddress pad where pad.id.partyId=:party_id and pad.id.startDate<=:current_date and pad.endDate>=:end_date")
	long Select_Address_id(@Param("party_id")String address_id,@Param("end_date")Date endDate,@Param("current_date")Date currentDate);
}
