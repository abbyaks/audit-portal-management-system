package com.prototype.auditauthentication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prototype.auditauthentication.model.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is used to handle all the errors. Here we are using class
 * {@link CustomErrorResponse} for returning the response. It will handle
 * generic as well as specific exceptions also.
 *
 */

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

	/**
	 * This method will handle login failed exception
	 * 
	 * ResponseEntity<CustomErrorResponse>
	 */

	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<CustomErrorResponse> handleIdNotFoundexception(LoginFailedException ex) {
		log.info("start");
		log.debug("LoginFailedException",ex);
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		log.info("end");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method will handle token expired exception
	 * ResponseEntity<CustomErrorResponse>
	 */

	@ExceptionHandler(TokenExpiredException.class)
	public ResponseEntity<CustomErrorResponse> handleTokenNotFoundexception(TokenExpiredException ex) {
		log.info("start");
		log.debug("TokenExpiredException",ex);
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"the token is expired and not valid anymore", ex.getMessage());
		log.info("end");

		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method will handle user not found exception
	 * ResponseEntity<CustomErrorResponse>
	 */

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleUserNotFoundexception(UsernameNotFoundException ex) {
		log.info("start");
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		log.info("end");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
}
