/**
 * 
 */
package com.amdocs.fx.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amdocs.fx.common.PropertyLoader;
import com.amdocs.fx.exception.UnableToExtractException;
import com.amdocs.fx.service.NCAService;

/**
 * @author jatinma
 *
 */
public class Main {

	/**
	 * @param args
	 */

	private static final String REPORT_FILES_DIRECORTY = "reportFilesDirectory";

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		final String reportFilesDirectory = PropertyLoader.getPropValue(Main.REPORT_FILES_DIRECORTY);

		if (reportFilesDirectory == null) {
			applicationContext.close();
			throw new UnableToExtractException("reportFilesDirectory not found in props file");
		}

		NCAService nCAService = (NCAService) applicationContext.getBean("ncaService");
		nCAService.accountCreate();
		applicationContext.close();
	}

}
