/**
 * 
 */
package com.trade.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import com.trade.entity.Banner

/**
 * @author jatin
 *
 */
@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

	
	public List<Banner>findByShowInUI(String showInUI);
	
	
}
