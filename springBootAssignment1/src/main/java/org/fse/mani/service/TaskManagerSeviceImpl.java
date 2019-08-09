package org.fse.mani.service;

import java.util.List;

import org.fse.mani.dao.TaskManagerDao;
import org.fse.mani.entities.ParentTask;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskManagerSeviceImpl implements TaskManagerService{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerSeviceImpl.class); 
	
    private TaskManagerDao taskManagerDao;

    @Autowired
    public TaskManagerSeviceImpl(TaskManagerDao taskManagerDao) {
        this.taskManagerDao = taskManagerDao;
    }
    
    public void addTask(Task task) {
        taskManagerDao.saveTask(task);
    }
    
    public void addParentTask(String parentTask) {
    	ParentTask task = new ParentTask();
    	task.setParent_task(parentTask);
        taskManagerDao.saveParentTask(task);
    }
    

	@Override
	public void endTask(int taskId) {
		
		taskManagerDao.endTask(taskId);
		
	}

	

	@Override
	public List<ParentTask> getParentTask() {
		
		List<ParentTask> parentTasksList =  taskManagerDao.getParentTask();
		
		LOGGER.info("Parent task List Size :"+parentTasksList.size());
		
        return parentTasksList;
		
	}

	@Override
	public List<Task> findAllTasks() {
		
		List<Task> allTaskDetails =  taskManagerDao.findAllTasks();
		
		LOGGER.info("Parent task List Size :"+allTaskDetails.size());
		
        return allTaskDetails;
		
		
	}

	@Override
	public Project findProjectById(int projectId) {
		
		Project projectDetails =  taskManagerDao.findProjectById(projectId);
		
		
		return projectDetails;
	}

	@Override
	public ParentTask getParenttaskById(int parentTaskId) {
		// TODO Auto-generated method stub
		return taskManagerDao.getParenttaskById(parentTaskId);
	}

	

}
