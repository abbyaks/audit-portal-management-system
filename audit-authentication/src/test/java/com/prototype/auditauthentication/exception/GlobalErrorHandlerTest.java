package com.prototype.auditauthentication.exception;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class GlobalErrorHandlerTest {

	@InjectMocks
	GlobalErrorHandler handler;

	@Mock
	Environment env;

	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}

	@Test
	public void testhandelWrongDateFormateException() {
		log.info("start");
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException()));
		log.info("end");
	}

	@Test
	public void testhandelWrongDateFormateExceptionThrowable() {
		log.info("start");
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException(new Throwable())));
		log.info("end");
	}

	@Test
	public void testhandelWrongDateFormateExceptionmsg() {
		log.info("start");
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException("message")));
		log.info("end");
	}

	@Test
	public void testhandelWrongDateFormateExceptionmsgThrowable() {
		log.info("start");
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException("msg", new Throwable())));
		log.info("end");
	}

	@Test
	public void testhandelWrongDateFormateExceptionmsgThrowtrue() {
		log.info("start");
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException("msg", new Throwable(), true, true)));
		log.info("end");
	}
}
