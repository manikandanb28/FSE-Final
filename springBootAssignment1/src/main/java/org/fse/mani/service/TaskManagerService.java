package org.fse.mani.service;

import java.util.List;

import org.fse.mani.entities.ParentTask;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;

public interface TaskManagerService {
	
	void addTask(Task task);	
	
	void addParentTask(String parentTask);
	
	void endTask(int taskId);
	
	List<Task> findAllTasks();
	
	List<ParentTask> getParentTask();
	
	Project findProjectById(int taskId);
	
	ParentTask getParenttaskById(int parentTaskId);
	
	
	
    
}
