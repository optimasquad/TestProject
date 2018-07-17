/**
 * 
 */
package com.trade.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author jatin
 *
 */

@Service
@Transactional
class MailService {

	@Autowired
	private JavaMailSender  javaMailSender;

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	/**
	 * This method will send compose and send the message
	 * */
	public void sendMail(String to, String subject, String body) {
		logger.info("sending the email....")
		SimpleMailMessage message = new SimpleMailMessage()
		message.setTo(to)
		message.setSubject(subject)
		message.setText(body)
		javaMailSender.send(message)
		logger.info("email sent.....")
	}

	/**
	 * This method will send a pre-configured message
	 * *//*
	 public void sendPreConfiguredMail(String message) {
	 SimpleMailMessage mailMessage = new SimpleMailMessage(simpleMailMessage)
	 mailMessage.setText(message)
	 mailSender.send(mailMessage)
	 }*/
}

