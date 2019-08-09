package org.fse.mani.repositories;

import java.util.List;

import org.fse.mani.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    
	User save(User user);
    
    List<User> findAll();
    
   /* @Query("SELECT tt FROM Task tt WHERE tt.task_id=(:taskId)")
    Task findTask(@Param("taskId") int taskId);*/
    
    
    @Query("SELECT u FROM User u WHERE u.user_id=(:userId) ")
    User findUser(@Param("userId") int userId);
    
    @Modifying
    @Query("DELETE User u WHERE u.user_id = ?1")
    void deleteUser(int userId);
    
    
    @Transactional
    @Modifying
    @Query("UPDATE User u set u.user_id =(:userId) where u.user_id =(:userId)")
    void updateUser(@Param("userId") int userId);
    
    /*@Query("SELECT u FROM User u WHERE u.Task.task_id=(:taskId) ")
    User findUserByTaskId(@Param("taskId") int taskId);*/
    
}
