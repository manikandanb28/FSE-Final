package org.fse.mani.dao;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.fse.mani.entities.ParentTask;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.fse.mani.repositories.ParentTaskRepository;
import org.fse.mani.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class TaskManagerDaoImpl implements TaskManagerDao {
	
    
    private TaskRepository taskRepository;
    
    private ParentTaskRepository parentTaskRepository;
    
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    public TaskManagerDaoImpl(TaskRepository taskRepository,ParentTaskRepository parentTaskRepository) {
       
        this.taskRepository = taskRepository;
        this.parentTaskRepository = parentTaskRepository;
    }
    
    public Task saveTask(Task task) {
    	
    	return taskRepository.save(task);
    }
    
 public ParentTask saveParentTask(ParentTask task) {
    	
    	return parentTaskRepository.save(task);
    }

	@Override
	public void endTask(int taskId) {
		
		taskRepository.endTask(taskId);
		
	}

	@Override
	public List<Task> findAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Project findProjectById(int projectId) {
		
		return taskRepository.findProjectById(projectId);
	}

	@Override
	public List<ParentTask> getParentTask() {
		return parentTaskRepository.findAll();
	}

	@Override
	public ParentTask getParenttaskById(int parentTaskId) {
		return parentTaskRepository.getParenttaskById(parentTaskId);
	}
}
