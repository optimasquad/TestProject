/**
 * 
 */
package com.kenan.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author jatin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {

	@XmlElement(name = "country")
	private String country;

	@XmlElement(name = "area")
	private String area;

	@XmlElement(name = "largest_city")
	private String largestCity;

	@XmlElement(name = "capital")
	private String capital;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "abbr")
	private String abbr;

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the abbr
	 */
	public String getAbbr() {
		return abbr;
	}

	/**
	 * @param abbr
	 *            the abbr to set
	 */
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the largestCity
	 */
	public String getLargestCity() {
		return largestCity;
	}

	/**
	 * @param largestCity
	 *            the largestCity to set
	 */
	public void setLargestCity(String largestCity) {
		this.largestCity = largestCity;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param capital
	 *            the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
