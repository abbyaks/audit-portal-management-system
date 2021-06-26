package com.prototype.auditauthentication.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author POD5
 * @version 1.8
 * @apiNote This class is used to hold the login credentials which will be sent
 *          by the user in the request body for getting the token
 *
 */
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();

	@Test
	public void testUserLoginCredentialAllConstructor() {
		log.info("start");
		UserCredentials credential = new UserCredentials("audit1", "password1");
		assertEquals(credential.getUserId(), "audit1");
		log.info("end");
	}

	@Test
	public void testGetUid() {
		log.info("start");
		loginCredential.setUserId("audit1");
		assertEquals(loginCredential.getUserId(), "audit1");
		log.info("end");
	}

	@Test
	public void testUserPassword() {
		log.info("start");
		loginCredential.setPassword("audit1");
		assertEquals(loginCredential.getPassword(), "audit1");
		log.info("end");

	}

	@Test
	public void testoString() {
		log.info("start");
		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);
		log.info("end");

	}

}
