/**
 * 
 */
package com.trade.repository


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.trade.entity.Party
import com.trade.entity.PartyAddress

/**
 * @author jatin
 *
 */
@Repository
public interface CustomerUserRepository extends JpaRepository<Party, Long> {


	Party findByUserName(String userName)
}
