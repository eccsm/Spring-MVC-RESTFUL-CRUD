package com.eccsm.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eccsm.model.Category;
import com.eccsm.repository.CategoryDao;

@SuppressWarnings("unchecked")
@Repository
public class CategoryDaoImpl implements CategoryDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);

	}


	@Override
	public List<Category> listCategories() {
		return sessionFactory.getCurrentSession().createQuery("FROM " + Category.class.getName()).list();
	}

	@Override
	public Category updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return category;
	}

	@Override
	public void deleteCategory(long id) {
		Category category = new Category();
		category.setId(id);
		sessionFactory.getCurrentSession().delete(category);

	}

	@Override
	public Category getCategory(long id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

}
