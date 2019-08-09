package org.fse.mani.service;

import java.util.List;

import org.fse.mani.entities.Project;

public interface ProjectServices {
	
	void addProject(Project project);	
	
	List<Project> findAllProjects();
	
	Project findProjectById(int projectId);

}
