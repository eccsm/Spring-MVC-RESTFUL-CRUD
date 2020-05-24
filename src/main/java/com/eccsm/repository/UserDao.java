package com.eccsm.repository;

import java.util.List;
import com.eccsm.model.User;

public interface UserDao {

	public void saveUser(User user);

	public List<User> listUsers();

	public User updateUser(User user);

	public void deleteUser(long id);

	public User getUser(long id);
	
	public User getUserByMail(String mail);

}
