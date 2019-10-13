package com.nagarro.amcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.amcart.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

	List<CategoryModel> findByCode(String code);
}
