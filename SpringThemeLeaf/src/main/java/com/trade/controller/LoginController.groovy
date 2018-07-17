/**
 * 
 */
package com.trade.controller

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import com.trade.model.UserRegistrationBean
import com.trade.service.CustomerService
import com.trade.service.MailService


/**
 * @author jatin
 *
 */
@Controller
class LoginController {


	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	// This needs to be authenticated.When the login credentials are true then
	// it has to be navigated to the login Page
	@Autowired
	CustomerService customerService;

	@Autowired
	MailService mailService;

	@RequestMapping("/login")
	public String login() {
		logger.info("Pass through forlogin");
		return "login/login";
	}

	/*@RequestMapping(value = "/verifylogin", method = RequestMethod.POST)
	 public String verifyLogin(@Valid UserAuthenticateBean userAuthenticateBean, BindingResult result, Model model,
	 Errors errors) {
	 logger.info("verifying the login with the login service");
	 return "login/login";
	 }
	 */


	@RequestMapping(value="/doRegister",method=RequestMethod.GET)
	public String doRegister (UserRegistrationBean userRegistrationBean, Model model) {
		logger.info("Pass through doRegister");
		model.addAttribute("userRegistrationBean",new UserRegistrationBean());
		return "register/register";
	}


	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register (@Valid UserRegistrationBean userRegistrationBean, BindingResult result, Errors errors,Model model) {
		logger.info("Pass through forRegister");

		/*		http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
		 */		
		logger.info("userRegistrationBean values are there");

		//Calling Dao for the manipulations
		userRegistrationBean=customerService.saveCustomer(userRegistrationBean)
		//model.addAttribute("userRegistrationBeanResponse", userRegistrationBeanResponse)

		//Mail is working fine.

		//mailService.sendMail("praveen9kp@gmail.com", "Welcome to Marriage Making", "Testing body")

		//logger.info "After registration redirect to login-"+userRegistrationBeanResponse.getUserId()
		//model.clear();
		model.addAttribute("userRegistrationBean",userRegistrationBean);
		return "login/result";
	}

}
