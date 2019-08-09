package org.fse.mani.repositories;

import java.util.List;

import org.fse.mani.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
	Project save(Project project);
    
    List<Project> findAll();
    
   @Query("SELECT p FROM Project p WHERE p.project_id=(:projectId)")
   Project findProject(@Param("projectId") int projectId);
    
    /*@Transactional
    @Modifying
    @Query("UPDATE Task set IsActive='N' where task_id =(:taskId)")
    void endTask(@Param("taskId") int task_id);*/
    
}
