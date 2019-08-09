package org.fse.mani.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectVO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3255535349492868584L;

	@JsonProperty("ProjectID")
	private int ProjectID;
	
	@JsonProperty("Project")
	private String Project;
	
	@JsonProperty("StartDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private String StartDate;

	@JsonProperty("EndDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private String EndDate;
	
	@JsonProperty("Priority")
	private int Priority;
	
	@JsonProperty("ManagerID")
	private int ManagerID;
	
	@JsonProperty("ManagerName")
	private String ManagerName;
	
	@JsonProperty("NoofTasks")
	private int NoofTasks;
	
	@JsonProperty("NoofCompletedTasks")
	private int NoofCompletedTasks;

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

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public int getManagerID() {
		return ManagerID;
	}

	public void setManagerID(int managerID) {
		ManagerID = managerID;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

	public int getNoofTasks() {
		return NoofTasks;
	}

	public void setNoofTasks(int noofTasks) {
		NoofTasks = noofTasks;
	}

	public int getNoofCompletedTasks() {
		return NoofCompletedTasks;
	}

	public void setNoofCompletedTasks(int noofCompletedTasks) {
		NoofCompletedTasks = noofCompletedTasks;
	}

}
