package com.eccsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eccsm.model.Category;
import com.eccsm.model.Item;
import com.eccsm.model.User;
import com.eccsm.service.APIService;

@CrossOrigin(maxAge = 3600)
@RestController
public class SrvController {

	@Autowired
	private APIService APIService;

	@RequestMapping(value = "item/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<?> updateItem(@RequestBody Item taken, @ModelAttribute Item item, @PathVariable long id,
			BindingResult result) {

		return APIService.updateItem(taken, item, id, result);

	}

	@RequestMapping(value = "item/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> saveItem(@RequestBody Item taken, @ModelAttribute Item item, BindingResult result) {

		return APIService.saveItem(taken, item, result);
	}

	@RequestMapping(value = "item/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteItem(@PathVariable long id) {

		return APIService.deleteItem(id);

	}

	@RequestMapping(value = "item/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getItemById(@PathVariable long id) {

		return APIService.getItem(id);

	}

	@RequestMapping(value = "item/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getItems() {

		return APIService.getItems();

	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<?> updateCategory(@RequestBody Category taken, @ModelAttribute Category category,
			@PathVariable long id, BindingResult result) {

		return APIService.updateCategory(taken, category, id, result);

	}

	@RequestMapping(value = "category/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> saveCategory(@RequestBody Category taken, @ModelAttribute Category category,
			BindingResult result) {

		return APIService.saveCategory(taken, category, result);
	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCategory(@PathVariable long id) {

		return APIService.deleteCategory(id);

	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getCategoryById(@PathVariable long id) {

		return APIService.getCategory(id);

	}

	@RequestMapping(value = "category/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getCategories() {

		return APIService.getCategories();

	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<?> updateUser(@RequestBody User taken, @ModelAttribute User user,
			@PathVariable long id, BindingResult result) {

		return APIService.updateUser(taken, user, id, result);

	}

	@RequestMapping(value = "user/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> saveCategory(@RequestBody User taken, @ModelAttribute User user,
			BindingResult result) {

		return APIService.saveUser(taken, user, result);
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {

		return APIService.deleteUser(id);

	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getUserById(@PathVariable long id) {

		return APIService.getUser(id);

	}

	@RequestMapping(value = "user/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getUsers() {

		return APIService.getUsers();

	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> login(@RequestBody User user) {

		return APIService.login(user);

	}

}
