package com.nagarro.amcart.dao;

import java.util.List;

import com.nagarro.amcart.model.CategoryModel;

public interface CategoryDAO {

	void save(CategoryModel categoryModel);
	
	CategoryModel get(Long id);
	 
	CategoryModel getByCode(String code);
	 
	 void delete(CategoryModel cartModel);
	 
	 public List<CategoryModel> findAll();


}
