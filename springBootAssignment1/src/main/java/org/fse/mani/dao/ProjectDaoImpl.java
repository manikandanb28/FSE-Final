package org.fse.mani.dao;

import java.util.List;

import org.fse.mani.entities.Project;
import org.fse.mani.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

	private ProjectRepository projectRepository;
	
	@Autowired
    public ProjectDaoImpl(ProjectRepository projectRepository) {
       
        this.projectRepository = projectRepository;
    }
	
	@Override
	public void saveProject(Project project) {
		
		projectRepository.save(project);
	}

	@Override
	public List<Project> findAllProjects() {
		
		return projectRepository.findAll();
		
	}

	@Override
	public Project findProjectById(int projectId) {
		// TODO Auto-generated method stub
		return projectRepository.findProject(projectId);
	}

}
