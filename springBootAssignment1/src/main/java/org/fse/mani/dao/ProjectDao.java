package org.fse.mani.dao;

import java.util.List;

import org.fse.mani.entities.Project;

public interface ProjectDao {
	
	void saveProject(Project project);
	
	List<Project> findAllProjects();
	
	Project findProjectById(int projectId);

}
