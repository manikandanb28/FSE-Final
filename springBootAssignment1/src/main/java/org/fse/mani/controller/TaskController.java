package org.fse.mani.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.fse.mani.entities.ParentTask;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.fse.mani.entities.User;
import org.fse.mani.model.ParentTaskVO;
import org.fse.mani.model.TaskVO;
import org.fse.mani.service.TaskManagerService;
import org.fse.mani.service.UserServices;
import org.fse.mani.util.FseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
		
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Tasks")
public class TaskController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

	public TaskManagerService taskManagerService;
	
	public UserServices userServices;
	
	@Autowired
	public TaskController(TaskManagerService taskManagerService,UserServices userServices) {
		this.taskManagerService = taskManagerService;
		this.userServices = userServices;
	}

	@RequestMapping(value = "/AddTask", method = RequestMethod.POST)
	public void saveTask(@RequestBody TaskVO taskVO) {

		ParentTask parentTask = new ParentTask();
		LOGGER.info("parent task id :"+taskVO.getParentTaskID());
		
		LOGGER.info("parent task :"+taskVO.getParentTask());
		
		parentTask.setParent_task(taskVO.getParentTask());
		parentTask.setParent_id(taskVO.getParentTaskID());
		
		Project project = new Project();
		project.setProject_id(taskVO.getProjectID());
		project.setProject(taskVO.getProject());
		
		Task task = new Task();
		task.setParentTask(parentTask);
		task.setProject(project);
		task.setTask(taskVO.getTask());
		task.setPriority(taskVO.getPriority());
		task.setStart_date(FseUtil.convertStringtoDate(taskVO.getStartDate()));
		task.setEnd_date(FseUtil.convertStringtoDate(taskVO.getEndDate()));
		task.setIsActive("Y");
		task.setParentTask(parentTask);
		parentTask.setTasks(Collections.singleton(task));
		project.setTasks(Collections.singleton(task));
		
		LOGGER.info("user id "+taskVO.getUserID());
		LOGGER.info(taskVO.getUserName());
		
		User user = userServices.findUserbyId(taskVO.getUserID());
		
		
		LOGGER.info(taskVO.getUserID()+ " Emp id: "+taskVO.getEmployeeID());
		user.setUser_id(taskVO.getUserID());
		user.setProject(project);
		user.setTask(task);
		
		//userServices.addUser(user);
		
		
		taskManagerService.addTask(task);
		

	}
	
	@RequestMapping(value = "/AddParentTask", method = RequestMethod.POST)
	public void saveParentTask(@RequestBody TaskVO taskVO) {

		LOGGER.info("parentTask :"+taskVO.getParentTask());
		taskManagerService.addParentTask(taskVO.getParentTask());

	}

	@RequestMapping(value = "/UpdateTask", method = RequestMethod.POST)
	public void update(@RequestBody TaskVO taskVO) {

		ParentTask parentTask = taskManagerService.getParenttaskById(taskVO.getParentTaskID());
		LOGGER.info("parent task id :"+taskVO.getParentTaskID());
		
		LOGGER.info("parent task :"+parentTask.getParent_task());
		
		parentTask.getTasks().clear();
		parentTask.setParent_task(parentTask.getParent_task());
		parentTask.setParent_id(taskVO.getParentTaskID());
		
		Project project = new Project();
		project.setProject_id(taskVO.getProjectID());
		project.setProject(taskVO.getProject());
		
		Task task = new Task();
		task.setParentTask(parentTask);
		task.setProject(project);
		task.setTask_id(taskVO.getTaskID());
		task.setTask(taskVO.getTask());
		task.setPriority(taskVO.getPriority());
		task.setStart_date(FseUtil.convertStringtoDate(taskVO.getStartDate()));
		task.setEnd_date(FseUtil.convertStringtoDate(taskVO.getEndDate()));
		task.setIsActive("Y");
		task.setParentTask(parentTask);
		parentTask.getTasks().addAll(Collections.singleton(task));
		project.setTasks(Collections.singleton(task));
		
		LOGGER.info("user id "+taskVO.getUserID());
		LOGGER.info(taskVO.getUserName());
		
		User user = userServices.findUserbyId(taskVO.getUserID());
		
		
		LOGGER.info(taskVO.getUserID()+ " Emp id: "+taskVO.getEmployeeID());
		user.setUser_id(taskVO.getUserID());
		user.setProject(project);
		user.setTask(task);
		task.setUsers(Collections.singleton(user));
		taskManagerService.addTask(task);

	}

	@RequestMapping(value = "/EndTask", method = RequestMethod.POST)
	public void endTask(@RequestBody TaskVO taskVO) {
		LOGGER.info("End task id : " + taskVO.getTaskID());
		taskManagerService.endTask( taskVO.getTaskID());

	}
	
	
	@GetMapping("/GetTasks/{id}")
	public List<TaskVO> findTasksById(@PathVariable(value = "id") int projectId) {

		LOGGER.info("Find Task by project id "+projectId);
		TaskVO taskVO = null;
		Project projectDetail = taskManagerService.findProjectById(projectId);
		
		Set<Task> tasks =  projectDetail.getTasks();
		
		List<TaskVO> taskList = new ArrayList<TaskVO>();
		Task task = null;
		for (Iterator<Task> it = tasks.iterator(); it.hasNext(); ) {
			
			task = it.next();
			LOGGER.info("task "+task.getTask());
			

			taskVO = new TaskVO();
			taskVO.setProjectID(task.getProject().getProject_id());
			taskVO.setProject(task.getProject().getProject());
			taskVO.setTaskID(task.getTask_id());
			taskVO.setTask(task.getTask());
			taskVO.setParentTaskID(task.getParentTask().getParent_id());
			taskVO.setParentTask(task.getParentTask().getParent_task());
			taskVO.setPriority(task.getPriority());
			taskVO.setStartDate(task.getStart_date()+"");
			taskVO.setEndDate(task.getEnd_date()+"");
			for (Iterator<User> itr = task.getUsers().iterator(); itr.hasNext(); ) {
				
				User user = itr.next();
				LOGGER.info("User :"+user.getFirst_name());
				taskVO.setUserID(user.getUser_id());
				taskVO.setUserName(user.getFirst_name()+" "+user.getLast_name());
			}
		/*	User user = userServices.findUserByTaskId(task.getTask_id());
			
			taskVO.setUserID(user.get);
			taskVO.setUserName(user.getFirst_name()+" "+user.getLast_name());
			*/
			
			if (task.getIsActive().equalsIgnoreCase("Y")) {
				LOGGER.info("Is task Active :"+task.getIsActive());
				taskVO.setStatus(false);
			}else {
				taskVO.setStatus(true);
			}
			
			taskList.add(taskVO);
	    }
		
		return taskList;
	}

	@GetMapping("/viewTasks")
	public List<TaskVO> findAllTasks() {
		List<Task> findAllTasks = taskManagerService.findAllTasks();

		TaskVO taskVO = null;
		List<TaskVO> tasks = new ArrayList<TaskVO>();

		for (Task task : findAllTasks) {
			taskVO = new TaskVO();
			taskVO.setTaskID(task.getTask_id());
			taskVO.setTask(task.getTask());
			taskVO.setPriority(task.getPriority());
			taskVO.setParentTask(task.getParentTask().getParent_task()+"");
			taskVO.setStartDate(task.getStart_date()+"");
			taskVO.setEndDate(task.getEnd_date()+"");
			if (task.getIsActive().equalsIgnoreCase("Y")) {
				taskVO.setStatus(true);
			}
			tasks.add(taskVO);
		}
		return tasks;
	}

	@GetMapping("/GetParentTasks")
	public List<ParentTaskVO> GetParentTasks() {
		
		
		List<ParentTask> parentTaskList = taskManagerService.getParentTask();
		
		ParentTaskVO parentTaskVO = null;
		List<ParentTaskVO> parentTasks = new ArrayList<ParentTaskVO>();

		for (ParentTask parentTask : parentTaskList) {
			parentTaskVO = new ParentTaskVO();
			parentTaskVO.setParentTaskID(parentTask.getParent_id());
			parentTaskVO.setParentTask(parentTask.getParent_task());
			parentTasks.add(parentTaskVO);
		}
		return parentTasks;
		
	}
	
	

}
