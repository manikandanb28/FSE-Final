package org.fse.mani.service;

import java.util.List;

import org.fse.mani.entities.User;

public interface UserServices {
	
	void addUser(User user);	
	
	List<User> findAllUsers();
	
	User findUserbyId(int UserId);
	
	void deleteUser(int userId);
	
}
