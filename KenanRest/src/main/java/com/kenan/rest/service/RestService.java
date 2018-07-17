/**
 * 
 */
package com.kenan.rest.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kenan.rest.model.Response;

/**
 * @author jatin
 *
 */
@Service
public class RestService {

	/**
	 * @param restTemplate,
	 *            this is the exact call to the service
	 */
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(RestService.class);

	public Response consumeService() {
		logger.info("Entering RestService to retrieve data");

		// Initializing the bean
		RestTemplate restTemplate = new RestTemplate();
		// Calling the service to retrieve the details
		Response response = restTemplate.getForObject("http://services.groupkt.com/state/get/IND/UP", Response.class);
		logger.info("Data successfully retrieved ends here.");
		return response;
	}

}
