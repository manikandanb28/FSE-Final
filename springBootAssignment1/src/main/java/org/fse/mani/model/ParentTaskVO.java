package org.fse.mani.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentTaskVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574436986384729651L;
	
	@JsonProperty("ParentTaskID")
	private int ParentTaskID;
	@JsonProperty("ParentTask")
	private String ParentTask;
	public int getParentTaskID() {
		return ParentTaskID;
	}
	public void setParentTaskID(int parentTaskID) {
		ParentTaskID = parentTaskID;
	}
	public String getParentTask() {
		return ParentTask;
	}
	public void setParentTask(String parentTask) {
		ParentTask = parentTask;
	}

}
