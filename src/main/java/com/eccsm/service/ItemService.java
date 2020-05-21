package com.eccsm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import com.eccsm.model.Item;
import com.eccsm.repository.impl.ItemDaoImpl;
import com.eccsm.validator.ItemValidator;

@Transactional
@Repository
public class ItemService {

	@Autowired
	private ItemDaoImpl itemDao;

	@Autowired
	private ItemValidator validator;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> updateitem(Item taken, Item item, long id, BindingResult result) {
		validator.validate(taken, result);
		if (!result.hasErrors()) {
			item = itemDao.getItem(id);

			item.setName(taken.getName());
			item.setPrice(taken.getPrice());
			item.setDescription(taken.getDescription());
			itemDao.updateItem(item);
			return new ResponseEntity(taken.getName() + " Updated",HttpStatus.OK);
		} else {
			return new ResponseEntity(result.toString(),HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> savetem(Item taken, Item item, BindingResult result) {

		validator.validate(taken, result);
		if (!result.hasErrors()) {

			itemDao.saveItem(taken);
			return new ResponseEntity(taken.getName() + " Created",HttpStatus.OK);

		} else {
			
			return new ResponseEntity(result.toString(),HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> deleteitem(long id) {

		itemDao.deleteItem(id);
		
		return new ResponseEntity("Success",HttpStatus.OK);
	
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> findAllitem() {

		List<Item> itemList = itemDao.listItems();
		return new ResponseEntity(itemList,HttpStatus.OK);
		
	}

}
