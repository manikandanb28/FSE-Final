package org.fse.mani.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 8820247801425771275L;
	
	private int task_id;
	private String task;
	private LocalDate start_date;
	private LocalDate end_date;
    private int priority;
    private ParentTask parentTask;
    private Project project;
    private String IsActive;
    private Set<User> users;
   

	@Id
	@AttributeOverride(name="id", column=@Column(name="task_id"))
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	@Column(name = "task")
    public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
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
	
	@Column(name = "IsActive")
	public String getIsActive() {
		return IsActive;
	}
	
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "parent_id",nullable=false)
    public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id",nullable=false)
    public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	 @OneToMany(mappedBy = "task",fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.MERGE)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
