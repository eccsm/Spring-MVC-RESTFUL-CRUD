package com.eccsm.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.eccsm.auth.JwtTokenUtil;
import com.eccsm.model.Category;
import com.eccsm.model.Item;
import com.eccsm.model.User;
import com.eccsm.repository.impl.CategoryDaoImpl;
import com.eccsm.repository.impl.ItemDaoImpl;
import com.eccsm.repository.impl.UserDaoImpl;
import com.eccsm.validator.CategoryValidator;
import com.eccsm.validator.ItemValidator;

@Transactional
@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class APIService {

	@Autowired
	private ItemDaoImpl itemDao;

	@Autowired
	private CategoryDaoImpl categoryDao;

	@Autowired
	private UserDaoImpl userDao;

	@Autowired
	private ItemValidator Ivalidator;

	@Autowired
	private CategoryValidator Cvalidator;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public ResponseEntity<?> updateItem(Item taken, Item item, long id, BindingResult result) {
		Ivalidator.validate(taken, result);
		if (!result.hasErrors()) {
			item = itemDao.getItem(id);

			item.setName(taken.getName());
			item.setPrice(taken.getPrice());
			item.setDescription(taken.getDescription());
			item.setCategory(taken.getCategory());
			item.setImageUrl(taken.getImageUrl());
			item.setCategory(taken.getCategory());
			itemDao.updateItem(item);
			return new ResponseEntity(taken.getName() + " Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity(result.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> saveItem(Item taken, Item item, BindingResult result) {

		Ivalidator.validate(taken, result);
		if (!result.hasErrors()) {

			itemDao.saveItem(taken);
			return new ResponseEntity(taken.getName() + " Created", HttpStatus.OK);

		} else {

			return new ResponseEntity(result.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> deleteItem(long id) {

		itemDao.deleteItem(id);

		return new ResponseEntity("Success", HttpStatus.OK);
	}

	public ResponseEntity<?> getItem(long id) {

		Item item = itemDao.getItem(id);
		return new ResponseEntity(item, HttpStatus.OK);
	}

	public ResponseEntity<?> getItems() {

		List<Item> itemList = itemDao.listItems();
		return new ResponseEntity(itemList, HttpStatus.OK);
	}

	public ResponseEntity<?> updateCategory(Category taken, Category category, long id, BindingResult result) {
		Cvalidator.validate(taken, result);
		if (!result.hasErrors()) {
			category = categoryDao.getCategory(id);

			category.setName(taken.getName());
			categoryDao.updateCategory(category);
			return new ResponseEntity(taken.getName() + " Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity(result.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> saveCategory(Category taken, Category category, BindingResult result) {

		Cvalidator.validate(taken, result);
		if (!result.hasErrors()) {

			categoryDao.saveCategory(taken);
			return new ResponseEntity(taken.getName() + " Created", HttpStatus.OK);

		} else {

			return new ResponseEntity(result.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> deleteCategory(long id) {

		categoryDao.deleteCategory(id);

		return new ResponseEntity("Success", HttpStatus.OK);

	}

	public ResponseEntity<?> getCategory(long id) {

		Category category = categoryDao.getCategory(id);
		return new ResponseEntity(category, HttpStatus.OK);

	}

	public ResponseEntity<?> getCategories() {

		List<Category> categoryList = categoryDao.listCategories();
		return new ResponseEntity(categoryList, HttpStatus.OK);

	}
	
	public ResponseEntity<?> updateUser(User taken, User user, long id, BindingResult result) {
		Cvalidator.validate(taken, result);
		if (!result.hasErrors()) {
			user = userDao.getUser(id);

			user.setName(taken.getName());
			userDao.updateUser(user);
			return new ResponseEntity(taken.getName() + " Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity(result.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> saveUser(User taken, User user, BindingResult result) {

			userDao.saveUser(taken);
			return new ResponseEntity(taken.getName() + " Created", HttpStatus.OK);
	
	}

	public ResponseEntity<?> deleteUser(long id) {

		userDao.deleteUser(id);

		return new ResponseEntity("Success", HttpStatus.OK);

	}

	public ResponseEntity<?> getUser(long id) {

		User user = userDao.getUser(id);
		return new ResponseEntity(user, HttpStatus.OK);

	}

	public ResponseEntity<?> getUsers() {

		List<User> userList = userDao.listUsers();
		return new ResponseEntity(userList, HttpStatus.OK);

	}
	
	public ResponseEntity<?> login(User user) {
		User logged = userDao.getUserByMail(user.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		if(encoder.matches(user.getPassword(), logged.getPassword()))
		{
			final String token = jwtTokenUtil.generateToken(logged);
			List<String> userData = new ArrayList<String>();
			userData.add(token);
			userData.add(logged.getName());
			userData.add(logged.getEmail());
			userData.add(String.valueOf(logged.getId()));
			return new ResponseEntity(userData.listIterator(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		

	}

}
