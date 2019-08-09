package org.fse.mani.dao;

import java.util.List;

import org.fse.mani.entities.ParentTask;
import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;

public interface TaskManagerDao {

    Task saveTask(Task task);
    
    ParentTask saveParentTask(ParentTask task);
    
    void endTask(int taskId);    

    List<Task> findAllTasks();
    
    Project findProjectById(int taskId);
    
    List<ParentTask> getParentTask();
    
    ParentTask getParenttaskById(int parentTaskId);
    
}
