package org.fse.mani.controller.test;

import static org.junit.Assert.*;

import java.util.List;

import org.fse.mani.SpringBootAssignmentApplication;
import org.fse.mani.controller.ProjectController;
import org.fse.mani.model.ProjectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAssignmentApplication.class)
public class ProjectControllerTest {
	

	@Autowired
	ProjectController projectController;

	@Test
	public void addProject() {

		ProjectVO  projectVO = new ProjectVO();
		projectVO.setProject("testproject");
		projectVO.setPriority(10);
		projectVO.setStartDate("2019-08-07");
		projectVO.setEndDate("2019-08-08");
		projectVO.setManagerID(1);
		projectController.saveProject(projectVO);
		
	}
	
	@Test
	public void updateProjecr() {
		ProjectVO  projectVO = new ProjectVO();
		projectVO.setProjectID(16);
		projectVO.setProject("testproject123");
		projectVO.setPriority(10);
		projectVO.setStartDate("2019-08-07");
		projectVO.setEndDate("2019-08-08");
		projectVO.setManagerID(1);
		projectController.updateProject(projectVO);
		
		
	}
	
	@Test
	public void findAllProjects() {
		
		List<ProjectVO> projects = projectController.findAllProjects();
		assertNotNull(projects);
		
	}

}
