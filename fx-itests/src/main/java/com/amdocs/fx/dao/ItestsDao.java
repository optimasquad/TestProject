package com.amdocs.fx.dao;

import com.amdocs.fx.entities.ITESTS_REF;

/**
 * 
 * 
 * @author jatinma
 *
 */
public interface ItestsDao {

	public void saveItests(ITESTS_REF itestsRef);

	public String load(String Key);

	public void delete();

}
