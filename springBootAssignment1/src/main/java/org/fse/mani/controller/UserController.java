package org.fse.mani.controller;

import java.util.ArrayList;
import java.util.List;

import org.fse.mani.entities.User;
import org.fse.mani.model.UserVO;
import org.fse.mani.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
		
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);
	
	public UserServices userServices;

	@Autowired
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}

	
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public void saveUser(@RequestBody UserVO userVO) {

		LOGGER.info("First Name :"+userVO.getFirstName());
		LOGGER.info("last Name :"+userVO.getLastName());
		LOGGER.info("Emp Id  :"+userVO.getEmployeeID());
		
		
		User user = new User();
		user.setFirst_name(userVO.getFirstName());
		user.setLast_name(userVO.getLastName());
		user.setEmployee_id(userVO.getEmployeeID());
		
		userServices.addUser(user);

	}
	
	@RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
	public void updateUser(@RequestBody UserVO userVO) {
		
		LOGGER.info("First Name :"+userVO.getFirstName());
		LOGGER.info("last Name :"+userVO.getLastName());
		LOGGER.info("Emp Id  :"+userVO.getEmployeeID());
		LOGGER.info("user Id  :"+userVO.getUserID());
		
		User user = userServices.findUserbyId(userVO.getUserID());

		user.setFirst_name(userVO.getFirstName());
		user.setLast_name(userVO.getLastName());
		user.setEmployee_id(userVO.getEmployeeID());
		
		
		userServices.addUser(user);
	}
	
	@GetMapping("/GetUsers")
	public List<UserVO> findAllUsers() {
		List<User> allUsers = userServices.findAllUsers();

		UserVO userVO = null;
		List<UserVO> users = new ArrayList<UserVO>();

		for (User user : allUsers) {
			userVO = new UserVO();
			userVO.setUserID(user.getUser_id());
			userVO.setFirstName(user.getFirst_name());
			userVO.setLastName(user.getLast_name());
			userVO.setEmployeeID(user.getEmployee_id());
			users.add(userVO);
		}
		return users;
	}
	
	@RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody UserVO userVO) {
		
		LOGGER.info("First Name :"+userVO.getFirstName());
		LOGGER.info("last Name :"+userVO.getLastName());
		LOGGER.info("Emp Id  :"+userVO.getEmployeeID());
		LOGGER.info("user Id  :"+userVO.getUserID());
		
		
		userServices.deleteUser(userVO.getUserID());
		//userServices.addUser(user);
	}
	

}
