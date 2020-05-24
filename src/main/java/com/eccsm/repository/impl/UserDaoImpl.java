package com.eccsm.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eccsm.auth.AuthConfig;
import com.eccsm.model.User;
import com.eccsm.repository.UserDao;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private AuthConfig authConfig;

	@Override
	public void saveUser(User user) {

		user.setPassword(authConfig.passwordEncoder().encode(user.getPassword()));
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> listUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM " + User.class.getName()).list();
	}

	@Override
	public User updateUser(User user) {
		user.setPassword(authConfig.passwordEncoder().encode(user.getPassword()));
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public void deleteUser(long id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User getUser(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User getUserByMail(String email) {
		
		List<User> list = new ArrayList<User>();
		
		list = listUsers();
		
		for (int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getEmail().equals(email)) {
				
				return list.get(i);
			}
		}
		return null;

	}

}
