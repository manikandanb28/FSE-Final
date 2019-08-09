package org.fse.mani.controller.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;

import org.fse.mani.SpringBootAssignmentApplication;
import org.fse.mani.config.JpaConfig;
import org.fse.mani.controller.UserController;
import org.fse.mani.dao.UserDaoImpl;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.fse.mani.entities.User;
import org.fse.mani.model.UserVO;
import org.fse.mani.service.UserServicesImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAssignmentApplication.class)
public class UserControllerTest {
	

	@Autowired
	UserController userController;

	@Test
	public void addUser() {

		UserVO  userVO = new UserVO();
		userVO.setFirstName("Manikandan");
		userVO.setLastName("Babu");
		userVO.setEmployeeID("310075");
		
		/*User user = new User();
		user.setFirst_name(userVO.getFirstName());
		user.setLast_name(userVO.getLastName());
		user.setEmployee_id(userVO.getEmployeeID());*/
		
		userController.saveUser(userVO);
		//List<User> findAll = userRepository.findAll();
		//assertNotNull(findAll);
	}
	
	@Test
	public void updateUser() {
		UserVO userVO = new UserVO();
		userVO.setUserID(1);
		userVO.setFirstName("Manikandan");
		userVO.setLastName("Babu");
		userVO.setEmployeeID("310075");
		
		userController.updateUser(userVO);
		
		
	}
	
	@Test
	public void deleteUser() {
		UserVO userVO = new UserVO();
		userVO.setUserID(6);
		userController.deleteUser(userVO);
		
		
	}
	
	@Test
	public void findAllusers() {
		
		List<UserVO> users = userController.findAllUsers();
		assertNotNull(users);
		
	}

}
