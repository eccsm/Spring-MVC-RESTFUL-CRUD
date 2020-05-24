package com.eccsm.repository;

import java.util.List;

import com.eccsm.model.Category;


public interface CategoryDao {

	public void saveCategory(Category category);

	public List<Category> listCategories();

	public Category updateCategory(Category category);

	public void deleteCategory(long id);

	public Category getCategory(long id);
}
