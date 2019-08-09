package org.fse.mani.dao;

import java.util.List;

import org.fse.mani.entities.User;
import org.fse.mani.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private UserRepository userRepository;
	
	@Autowired
    public UserDaoImpl(UserRepository userRepository) {
       
        this.userRepository = userRepository;
    }
	
	@Override
	public void save(User user) {
		
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		userRepository.updateUser(user.getUser_id());
		
	}

	@Override
	public User findUserById(int userId) {
		return userRepository.findUser(userId);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteUser(userId);
	}

	/*@Override
	public User findUserByTaskId(int taskId) {
		// TODO Auto-generated method stub
		return userRepository.findUserByTaskId(taskId);
	}*/

}
