package com.prototype.auditauthentication.model;

import static org.junit.Assert.*;

/**
 * @author POD5
 * @version 1.8
 * @apiNote To test ProjectManager class
 * 
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
public class ProjectManagerTest {

	ProjectManager projectManager = new ProjectManager();

	@Test
	public void testProjectManagerAllConstructor() {
		log.info("start");
		ProjectManager manager = new ProjectManager("audit1", "password1", null);
		assertEquals("audit1", manager.getUserId());
		log.info("stop");
	}

	@Test
	public void testUserid() {
		log.info("start");
		projectManager.setUserId("audit1");
		assertEquals("audit1", projectManager.getUserId());
		log.info("end");
	}

	@Test
	public void testUserPassword() {
		projectManager.setPassword("audit1");
		assertEquals("audit1", projectManager.getPassword());
	}

	@Test
	public void testAuthToken() {
		projectManager.setAuthToken("audit1");
		assertEquals("audit1", projectManager.getAuthToken());
	}

	@Test
	public void testoString() {
		String string = projectManager.toString();
		assertEquals(string, projectManager.toString());
	}

}
