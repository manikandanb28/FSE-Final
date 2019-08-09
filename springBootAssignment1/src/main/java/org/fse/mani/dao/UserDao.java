package org.fse.mani.dao;

import java.util.List;

import org.fse.mani.entities.User;

public interface UserDao {
	
	void save(User user);
	
	List<User> findAllUsers();
	
	void updateUser(User user);
	
	User findUserById(int userId);
	
	void deleteUser(int userId);
	
	//User findUserByTaskId(int taskId);

}
