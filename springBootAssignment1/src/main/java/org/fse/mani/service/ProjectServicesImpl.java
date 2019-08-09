package org.fse.mani.service;

import java.util.List;

import org.fse.mani.dao.ProjectDao;
import org.fse.mani.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServicesImpl implements ProjectServices {

	 private ProjectDao projectDao;

	    @Autowired
	    public ProjectServicesImpl(ProjectDao projectDao) {
	        this.projectDao = projectDao;
	    }
	
	@Override
	public void addProject(Project project) {
		projectDao.saveProject(project);

	}

	@Override
	public List<Project> findAllProjects() {
		return projectDao.findAllProjects();
	}

	@Override
	public Project findProjectById(int projectId) {
		// TODO Auto-generated method stub
		return projectDao.findProjectById(projectId);
	}

}
