package com.prototype.auditauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditauthentication.exception.LoginFailedException;
import com.prototype.auditauthentication.model.AuthResponse;
import com.prototype.auditauthentication.model.ProjectManager;
import com.prototype.auditauthentication.model.UserCredentials;
import com.prototype.auditauthentication.service.JwtUtil;
import com.prototype.auditauthentication.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is having all the endpoints related to authorization purpose. For
 * getting the token and validating the token this class willbe used.
 *
 */

@RestController
@Slf4j
public class AuthController {

	/**
	 * This is a private field of type {@link ManagerService} class which is used to
	 * fetch the user credentials from the database
	 */
	@Autowired
	ManagerService managerService;

	/**
	 * This is a private field of type {@link JwtUtil} class which provides the
	 * utilities for the token like get token, validate token, expiration time etc.
	 */
	@Autowired
	JwtUtil jwtUtil;

	/**
	 * This method is used to check the credentials whether the provided credentials
	 * are correct or not. For this we will call authenticate method. If user
	 * credentials are correct then we will fetch the data from database based on
	 * userid and return it to the user with a token
	 * 
	 * 
	 */

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials) throws Exception {
		log.info("start");
		log.debug(userCredentials.toString());

		final UserDetails userDetails = managerService.loadUserByUsername(userCredentials.getUserId());

		if (userDetails.getPassword().equals(userCredentials.getPassword())) {
			String token = jwtUtil.generateToken(userDetails);
			ProjectManager projectManager = new ProjectManager(userCredentials.getUserId(),
					userCredentials.getPassword(), token);
			managerService.saveUser(projectManager);
			log.info("end");
			return new ResponseEntity<>(projectManager, HttpStatus.OK);

		} else {
			log.error("access denied");
			log.info("access denied");
			throw new LoginFailedException("Invalid Credentials");
		}
	}

	/**
	 * This method is used to check whether the provided token is valid or not. For
	 * this we will call validate method. If token is valid then it will return the
	 * auth response
	 */

	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		ResponseEntity<?> response = null;
		log.info("start");
		log.debug("auth token", token);
		try {
			if (jwtUtil.validateToken(token)) {

				res.setUid(jwtUtil.extractUsername(token));
				res.setValid(true);

			}
		} catch (Exception e) {
			res.setValid(false);
			log.info("end");
			log.info("exception ", e.getMessage());
			System.out.println(e.getMessage());
			if (e.getMessage().contains("the token is expired and not valid anymore")) {
				response = new ResponseEntity<String>("the token is expired and not valid anymore",
						HttpStatus.FORBIDDEN);
			}
			if (e.getMessage().contains("Authentication Failed. Username or Password not valid")) {
				response = new ResponseEntity<String>("Authentication Failed. Username or Password not valid",
						HttpStatus.FORBIDDEN);
			}
			response = new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
			return response;
		}
		log.info("end");
		response = new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
		return response;

	}

}
