package org.fse.mani.controller;

import java.util.ArrayList;
import java.util.List;


import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.fse.mani.entities.User;
import org.fse.mani.model.ProjectVO;
import org.fse.mani.service.ProjectServices;
import org.fse.mani.service.UserServices;
import org.fse.mani.util.FseUtil;
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
@RequestMapping("/Projects")
public class ProjectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	
	public ProjectServices projectServices;
	
	public UserServices userServices;

	@Autowired
	public ProjectController(ProjectServices projectServices,UserServices userServices) {
		this.projectServices = projectServices;
		this.userServices = userServices;
	}

	
	@RequestMapping(value = "/AddProject", method = RequestMethod.POST)
	public void saveProject(@RequestBody ProjectVO projectVO) {

		LOGGER.info("Project ID :"+projectVO.getProjectID());
		LOGGER.info("Project Name:"+projectVO.getProject());
		LOGGER.info("Manager Id:"+projectVO.getManagerID());
		LOGGER.info("Manager Id:"+projectVO.getManagerID());
		LOGGER.info("manager Name  :"+projectVO.getManagerName());
		
		LOGGER.info("Start date :"+projectVO.getStartDate());
		LOGGER.info("End date :"+projectVO.getEndDate());
		
		Project project = new Project();
		project.setProject_id(projectVO.getProjectID());
		project.setProject(projectVO.getProject());
		project.setPriority(projectVO.getPriority());
		project.setStart_date(FseUtil.convertStringtoDate(projectVO.getStartDate()));
		project.setEnd_date(FseUtil.convertStringtoDate(projectVO.getEndDate()));
		User user =  userServices.findUserbyId(projectVO.getManagerID());
		user.setProject(project);
		projectServices.addProject(project);
		

	}
	
	
	@RequestMapping(value = "/UpdateProject", method = RequestMethod.POST)
	public void updateProject(@RequestBody ProjectVO projectVO) {

		LOGGER.info("Project ID :"+projectVO.getProjectID());
		LOGGER.info("Project Name:"+projectVO.getProject());
		LOGGER.info("Manager Id:"+projectVO.getManagerID());
		LOGGER.info("Manager Id:"+projectVO.getManagerID());
		LOGGER.info("manager Name  :"+projectVO.getManagerName());
		
		LOGGER.info("Start date :"+projectVO.getStartDate());
		LOGGER.info("End date :"+projectVO.getEndDate());
		
		Project project = projectServices.findProjectById(projectVO.getProjectID());
		
		project.setProject(projectVO.getProject());
		project.setPriority(projectVO.getPriority());
		project.setStart_date(FseUtil.convertStringtoDate(projectVO.getStartDate()));
		project.setEnd_date(FseUtil.convertStringtoDate(projectVO.getEndDate()));
		User user =  userServices.findUserbyId(projectVO.getManagerID());
		user.setProject(project);
		projectServices.addProject(project);
		

	}
	
	
	@GetMapping("/GetProjects")
	public List<ProjectVO> findAllProjects() {
		List<Project> allProjects = projectServices.findAllProjects();

		ProjectVO projectVO = null;
		List<ProjectVO> projectList = new ArrayList<ProjectVO>();
		
		for (Project project : allProjects) {
			projectVO = new ProjectVO();
			
			projectVO.setProjectID(project.getProject_id());
			projectVO.setProject(project.getProject());
			projectVO.setPriority(project.getPriority());
			projectVO.setStartDate(project.getStart_date()+"");
			projectVO.setEndDate(project.getEnd_date()+"");
			
			
			
			if(project.getTasks()!=null) {
				
				if(project.getTasks()!=null) {
					int completedTask = 0;
					projectVO.setNoofTasks(project.getTasks().size());
					for(Task task : project.getTasks()) {
						if(task.getIsActive().equalsIgnoreCase("N")) {
							++completedTask;
						}
					}
					projectVO.setNoofCompletedTasks(completedTask);
				}else {
					projectVO.setNoofTasks(0);
				}
				
				
			}
			
			
			projectList.add(projectVO);
		}
		return projectList;
	}
	

}
