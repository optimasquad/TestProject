/**
 * 
 */
package com.trade.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trade.common.Tradeconstants;

/**
 * @author jatin
 *
 */
public class UtilityHelper {

	// This is the generic class for the methods to be handled

	private static final Logger logger = LoggerFactory.getLogger(UtilityHelper.class);

	private static final String CLASSNAME = UtilityHelper.class.getName();

	public UtilityHelper() {

	}

	/**
	 * 
	 * This is the genaric method to give the date in the response
	 * 
	 * @return
	 */
	public static Date getDate() {
		Date date = new Date();
		return date;

	}

	/**
	 * 
	 * @return
	 */
	public static final Date getLastDate() {
		Date date = null;
		final String methodName = "getLastDate";
		try {
			date = new SimpleDateFormat(Tradeconstants.DATE_FORMAT_DD_MMM_YYYY).parse(Tradeconstants.END_DATE);
		} catch (Exception e) {
			logger.error("Parsing has failed for the Method" + methodName + " and class" + CLASSNAME);
		}
		return date;
	}

}
