package org.fse.mani.dao.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.fse.mani.SpringBootAssignmentApplication;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.User;
import org.fse.mani.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAssignmentApplication.class)
//@ContextConfiguration(classes = {JpaConfig.class,UserDaoImpl.class})
public class UserDaoTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setFirst_name("Manikandan1");
		user.setLast_name("Babu1");
		user.setEmployee_id("310076");
		Project project = new Project();
		project.setProject_id(5);
		user.setProject(project);
		userRepository.save(user);
		List<User> findAll = userRepository.findAll();
		assertNotNull(findAll);
       
	}

}
