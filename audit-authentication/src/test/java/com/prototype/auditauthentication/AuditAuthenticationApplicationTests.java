package com.prototype.auditauthentication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditAuthenticationApplicationTests {

	@Mock
	AuditAuthenticationApplication application=new AuditAuthenticationApplication();

	@Test
	void contextLoads() {
		assertNotNull(application);
	}

}


