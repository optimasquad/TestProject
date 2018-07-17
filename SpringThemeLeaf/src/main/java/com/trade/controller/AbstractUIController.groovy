/**
 * 
 */
package com.trade.controller

import javax.servlet.http.HttpServletRequest

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * @author jatin
 *
 */
@Controller
abstract class AbstractUIController {

	static  org.slf4j.Logger logger = LoggerFactory.getLogger(AbstractUIController.class)

	@ExceptionHandler(Exception.class)
	public String genericExceptionHandling(HttpServletRequest req, Exception exception, Model model) {
		logger.info exception.printStackTrace()
		logger.info "genericExceptionHandling ${exception.getMessage()}"

		model.addAttribute("exception", exception);
		model.addAttribute("url", req.getRequestURL());
		return "404"
	}
}
