package org.fse.mani.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

    private int project_id;
    private String project;
    private LocalDate start_date;
	private LocalDate end_date;
    private int priority;
    private Set<Task> tasks;
    
    public Project() {
    }

    public Project(int project_id) {
        this.project_id = project_id;
    }
    
    public Project(int project_id, String project,LocalDate start_date,LocalDate end_date,int priority, Set<Task> tasks) {
        this.project_id = project_id;
        this.project = project;
        this.start_date = start_date;
        this.end_date = end_date;
        this.priority = priority;
        this.tasks= tasks;
        
    }

    @Id
    @Column(name = "project_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
   

    @Column(name = "project")
    public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	@Column(name = "start_date")
	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	@Column(name = "end_date")
	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	@Column(name = "priority")
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	

    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.MERGE)
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return project_id == project.project_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(project_id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "Project Id =" + project_id +
                ", project='" + project + '\'' +
                '}';
    }
	

	
}
