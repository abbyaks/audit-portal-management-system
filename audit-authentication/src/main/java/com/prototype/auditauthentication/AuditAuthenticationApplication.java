package com.prototype.auditauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuditAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditAuthenticationApplication.class, args);
	}

}
