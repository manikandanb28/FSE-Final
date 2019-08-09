package org.fse.mani.repositories;

import java.util.List;
import java.util.UUID;

import org.fse.mani.entities.ParentTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ParentTaskRepository extends Repository<ParentTask, UUID> {
    
	ParentTask save(ParentTask task);
	
    List<ParentTask>findAll();
 
    @Query("SELECT pt FROM ParentTask pt WHERE pt.parent_id=(:parentTaskId) ")
    ParentTask getParenttaskById(@Param("parentTaskId") int parentTaskId);
}
