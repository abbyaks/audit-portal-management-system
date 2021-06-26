package com.prototype.auditauthentication.exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class LoginFailedExceptionTest {

	@Test
	public void testInvalidAuthorizationException() {
		log.info("start");
		LoginFailedException loginFailedException = new LoginFailedException("Invalid Credentials");
		assertNotNull(loginFailedException);
		log.info("end");

	}

}
