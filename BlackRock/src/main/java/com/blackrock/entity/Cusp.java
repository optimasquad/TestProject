/**
 * 
 */
package com.blackrock.entity;

import java.io.Serializable;

/**
 * @author jatin
 *
 */
public class Cusp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5479760646016164255L;

	private String id;

	private String portfolio;

	private String date;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the portfolio
	 */
	public String getPortfolio() {
		return portfolio;
	}

	/**
	 * @param portfolio
	 *            the portfolio to set
	 */
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
