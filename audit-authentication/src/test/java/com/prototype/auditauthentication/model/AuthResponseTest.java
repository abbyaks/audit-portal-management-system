package com.prototype.auditauthentication.model;

import static org.junit.Assert.*;

/**
 * @author POD5
 *  For testing the AuthResponse 
 * 
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthResponseTest {

AuthResponse authResponse=new AuthResponse();

	@Test
	public void testAuthResponseConstructor()
	{
		log.info("start");
		AuthResponse response=new AuthResponse("audit1", true);
		assertEquals( "audit1" ,  response.getUid() );
		log.info("end");
	}

	@Test
	public void testUid()
	{
		log.info("start");
		authResponse.setUid("audit1");
		assertEquals("audit1" , authResponse.getUid() );
		log.info("end");
	}

	@Test
	public void testIsValid()
	{
		log.info("start");
		authResponse.setValid(true);
		assertEquals( true , authResponse.isValid());
		log.info("end");
	}

	@Test
	public void testtoString() 
	{
		log.info("start");
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
        log.info("end");
    }

}
