package org.fse.mani.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 8820247801425771275L;
	
	private int user_id;
	private String first_name;
	private String last_name;
	private String employee_id;
    private Task task;
    private Project project;

	@Id
	@AttributeOverride(name="id", column=@Column(name="user_id"))
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Column(name = "first_name")
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name = "last_name")
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(name = "employee_id")
	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id",nullable=false)
    public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id",nullable=false)
    public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

	
	
	

	
	
}
