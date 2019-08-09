package org.fse.mani.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.fse.mani.config.JpaConfig;
import org.fse.mani.dao.UserDaoImpl;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.fse.mani.entities.User;
import org.fse.mani.service.UserServicesImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.format.annotation.DateTimeFormat;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate publishDate;

	@InjectMocks
	UserServicesImpl userService;

	@InjectMocks
	JpaConfig config;

	@Mock
	UserDaoImpl dao;
	
	
	@Test
	public void addUser() {

		User user = new User();
		user.setFirst_name("Manikandan");
		user.setLast_name("Babu");
		user.setEmployee_id("310075");
		Project project = new Project();
		Task task = new Task();
		user.setProject(project);
		user.setTask(task);
		userService.addUser(user);
		verify(dao, times(1)).save(user);
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setUser_id(1);
		user.setFirst_name("Manikandan");
		user.setLast_name("Babu");
		user.setEmployee_id("310075");
		Project project = new Project();
		Task task = new Task();
		user.setProject(project);
		user.setTask(task);
		userService.addUser(user);
		verify(dao, times(1)).save(user);
		
	}
	
	@Test
	public void deleteUser() {
		int userId =3;
		userService.deleteUser(userId);
		verify(dao, times(1)).deleteUser(userId);
		
	}
	
	@Test
	public void findAllusers() {
		
		userService.findAllUsers();
		verify(dao, times(1)).findAllUsers();
		
	}
	
	@Test
	public void findUsersBYId() {
		int userId = 1;
		userService.findUserbyId(userId);
		verify(dao, times(1)).findUserById(userId);
		
	}


}
