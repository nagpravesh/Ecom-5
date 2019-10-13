package com.nagarro.amcart.dao;

import java.util.List;

import com.nagarro.amcart.model.ProductModel;

public interface ProductDAO {

	void save(ProductModel productModel);
	
	 ProductModel get(Long id);
	 
	 ProductModel getByCode(String code);
	 
	 void delete(ProductModel productModel);
	 
	 List<ProductModel> findAll();
	 
	 List<ProductModel> findAllNewProducts();
	 
	 List<ProductModel> findAllFeaturedProducts();
	 
	 List<ProductModel> findAllBestSellerProducts();
	 
	 List<ProductModel> findAllSpecialProducts();

}
