package com.eccsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.eccsm.model.Item;
import com.eccsm.service.ItemService;


@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "item/update/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<?> update(@RequestBody Item taken, @ModelAttribute Item item, @PathVariable long id,
			BindingResult result) {

		return itemService.updateitem(taken, item, id, result);

	}

	@RequestMapping(value = "item/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> save(@RequestBody Item taken, @ModelAttribute Item item, BindingResult result) {

		return itemService.savetem(taken, item, result);
	}

	@RequestMapping(value = "item/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> delete(@PathVariable long id) {

		return itemService.deleteitem(id);
		
		

	}

	@RequestMapping(value = "item/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> findAll() {

		return itemService.findAllitem();

	}

}
