package com.prototype.auditauthentication.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditauthentication.model.ProjectManager;
import com.prototype.auditauthentication.repository.ManagerRepo;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ManagerServiceTest {

UserDetails userdetails;
	
	@InjectMocks
	ManagerService managerdetailservice;

	@Mock
	ManagerRepo userservice;

	@Test
	public void loadUserByUsernameTest() {
		log.info("start");
		ProjectManager user1=new ProjectManager("audit1","password1",null);
		Optional<ProjectManager> data =Optional.of(user1) ;
		when(userservice.findById("audit1")).thenReturn(data);
		UserDetails loadUserByUsername2 = managerdetailservice.loadUserByUsername("audit1");
		assertEquals(user1.getUserId(),loadUserByUsername2.getUsername());
		log.info("end");
	}

}
