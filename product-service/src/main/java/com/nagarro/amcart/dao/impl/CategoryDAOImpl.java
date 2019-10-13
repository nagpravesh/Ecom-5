package com.nagarro.amcart.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.amcart.dao.CategoryDAO;
import com.nagarro.amcart.model.CategoryModel;
import com.nagarro.amcart.repository.CategoryRepository;

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void save(CategoryModel categoryModel) {
		categoryRepository.save(categoryModel);
	}

	@Override
	public CategoryModel get(Long id) {
		return categoryRepository.getOne(id);
	}

	@Override
	public CategoryModel getByCode(String code) {
		CategoryModel categoryModel=null;
		List<CategoryModel> categories= categoryRepository.findByCode(code);
		if(categories.size()>1){
			//TODO: Throw exception
		}
		if(!categories.isEmpty()){
			categoryModel=categories.get(0);
		}
		return categoryModel;
	}
	
	@Override
	public List<CategoryModel> findAll(){
		return categoryRepository.findAll();
	}

	@Override
	public void delete(CategoryModel categoryModel) {
		categoryRepository.delete(categoryModel);
	}

}
