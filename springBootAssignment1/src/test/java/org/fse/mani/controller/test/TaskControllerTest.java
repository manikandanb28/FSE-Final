package org.fse.mani.controller.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.fse.mani.SpringBootAssignmentApplication;
import org.fse.mani.controller.TaskController;
import org.fse.mani.model.ParentTaskVO;
import org.fse.mani.model.TaskVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAssignmentApplication.class)
public class TaskControllerTest {
	

	@Autowired
	TaskController taskController;

	@Test
	public void addTask() {

		TaskVO taskVO = new TaskVO();
		
		taskVO.setParentTaskID(25);
		taskVO.setParentTask("NAVX2.0");
		taskVO.setProjectID(16);
		taskVO.setProject("testproject123");
		taskVO.setTask("Test Task");
		taskVO.setPriority(10);
		taskVO.setStartDate("2019-08-08");
		taskVO.setEndDate("2019-08-09");
		taskVO.setUserID(22);
		taskController.saveTask(taskVO);
	}
	
	@Test
	public void updateTask() {
		TaskVO taskVO = new TaskVO();
		taskVO.setParentTaskID(25);
		taskVO.setParentTask("NAVX2.0");
		taskVO.setProjectID(16);
		taskVO.setProject("testproject123");
		taskVO.setTaskID(16);
		taskVO.setTask("Test Task123");
		taskVO.setPriority(10);
		taskVO.setStartDate("2019-08-08");
		taskVO.setEndDate("2019-08-09");
		taskVO.setUserID(22);
		taskController.update(taskVO);
		
		
	}
	
	
	@Test
	public void saveParentTask() {

		TaskVO taskVO = new TaskVO();
		taskVO.setParentTask("NAVX2.0123");
		taskController.saveParentTask(taskVO);
	}
	
	@Test
	public void GetParentTasks() {
		List<ParentTaskVO> parenttaslList = taskController.GetParentTasks();
		assertNotNull(parenttaslList);
	}
	
	@Test
	public void findAllTasks() {
		List<TaskVO> taskList = taskController.findAllTasks();
		assertNotNull(taskList);
	}
	
	@Test
	public void findTasksById() {
		List<TaskVO> taskList = taskController.findTasksById(5);
		assertNotNull(taskList);
	}
	
	
	
	
	/*
	
	/*@Test
	public void deleteUser() {
		UserVO userVO = new UserVO();
		userVO.setUserID(6);
		userController.deleteUser(userVO);
		
		
	}
	
	@Test
	public void findAllusers() {
		
		List<UserVO> users = userController.findAllUsers();
		assertNotNull(users);
		
	}*/

}
