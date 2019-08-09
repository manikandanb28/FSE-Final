package org.fse.mani.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.fse.mani.entities.Project;
import org.fse.mani.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    
	Task save(Task task);
    
    List<Task> findAll();
    
    @Query("SELECT tt FROM Project tt WHERE tt.project_id=(:projectId) ")
    Project findProjectById(@Param("projectId") int projectId);
    
    
    @Transactional
    @Modifying
    @Query("UPDATE Task set IsActive='N' where task_id =(:taskId)")
    void endTask(@Param("taskId") int task_id);
    
    
    
}
