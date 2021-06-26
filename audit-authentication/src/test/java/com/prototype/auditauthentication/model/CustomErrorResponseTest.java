package com.prototype.auditauthentication.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class CustomErrorResponseTest {

	@Mock
	Environment env;

	@Test
	public void testCustomErrorResponse() {
		log.info("start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		assertNotNull(customErrorResponse);
		log.info("end");
	}

	@Test
	public void testCustomErrorResponseParameterized() {
		log.info("start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK, "Message",
				"reason");
		assertNotNull(customErrorResponse);
		log.info("end");

	}

	@Test
	public void testToStringMethod() {
		log.info("start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK, "Message",
				"reason");
		assertEquals(customErrorResponse.toString(), customErrorResponse.toString());
		log.info("end");

	}

	@Test
	public void testGetStatus() {
		log.info("start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());
		log.info("end");

	}

	@Test
	public void testGetMessage() {
		log.info("start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");
		assertEquals("Message", customErrorResponse.getMessage());
		log.info("end");

	}

	@Test
	public void testSetLocalDateTime() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setTimestamp(LocalDateTime.now());

	}

	@Test
	public void testSetStatus() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);

	}

	@Test
	public void testSetMessage() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");

	}

}
