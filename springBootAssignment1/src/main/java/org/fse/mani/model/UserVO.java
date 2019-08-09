package org.fse.mani.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3337957730945136023L;

	@JsonProperty("FirstName")
	private String FirstName;

	@JsonProperty("LastName")
	private String LastName;
	
	@JsonProperty("EmployeeID")
	private String EmployeeID;
	
	@JsonProperty("UserID")
	private int UserID;
	
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

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	

}
