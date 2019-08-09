package org.fse.mani.service;

import java.util.List;

import org.fse.mani.dao.UserDao;
import org.fse.mani.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

	 private UserDao userDao;

	    @Autowired
	    public UserServicesImpl(UserDao userDao) {
	        this.userDao = userDao;
	    }
	
	@Override
	public void addUser(User user) {
		userDao.save(user);

	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public User findUserbyId(int userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public void deleteUser(int userId) {
		
		userDao.deleteUser(userId);
		
	}

}
