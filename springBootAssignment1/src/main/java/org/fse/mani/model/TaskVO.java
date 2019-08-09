package org.fse.mani.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574436986384729651L;
	
	@JsonProperty("TaskID")
	private int TaskID;
	@JsonProperty("Task")
	private String Task;
	@JsonProperty("Priority")
	private int Priority;
	@JsonProperty("ParentTask")
	private String ParentTask;

	@JsonProperty("StartDate")
	@NotNull
	private String StartDate;

	@JsonProperty("EndDate")
	@NotNull
	private String EndDate;

	@JsonProperty("Status")
	private boolean Status;
	
	
	
	
	@JsonProperty("ParentTaskID")
	private int ParentTaskID;
	
	@JsonProperty("ProjectID")
	private int ProjectID;
	
	@JsonProperty("Project")
	private String Project;
	
	@JsonProperty("UserID")
	private int UserID;
	
	@JsonProperty("UserName")
	private String UserName;
	
	@JsonProperty("FirstName")
	private String FirstName;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	@JsonProperty("LastName")
	private String LastName;
	
	@JsonProperty("EmployeeID")
	private String EmployeeID;
	
	
	public int getTaskID() {
		return TaskID;
	}

	public void setTaskID(int taskID) {
		TaskID = taskID;
	}

	public String getTask() {
		return Task;
	}

	public void setTask(String task) {
		Task = task;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public String getParentTask() {
		return ParentTask;
	}

	public void setParentTask(String parentTask) {
		ParentTask = parentTask;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public boolean Status() {
		return Status;
	}

	public void setStatus(boolean Status) {
		this.Status = Status;
	}

	public int getParentTaskID() {
		return ParentTaskID;
	}

	public void setParentTaskID(int parentTaskID) {
		ParentTaskID = parentTaskID;
	}

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String project) {
		Project = project;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	/*public TaskVO(int TaskID,@NotNull String Task, @NotNull @DecimalMin(value = "1.00", message = "Minimum value should be equal or more than 1.00") int Priority,@NotNull String ParentTask, @NotNull LocalDate StartDate,@NotNull LocalDate EndDate) {
        this.TaskID = TaskID;
        this.Task = Task;	        
        this.Priority=Priority;
        this.ParentTask=ParentTask;
        this.StartDate=StartDate;			
        this.EndDate=EndDate;
        this.IsActive=true;
    }*/

}
