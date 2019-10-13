package com.nagarro.amcart.service;

import java.util.List;

import com.nagarro.amcart.model.ProductModel;

public interface ProductService {

	ProductModel findProductByCode(String code);

	void save(ProductModel productModel);

	ProductModel get(Long id);

	void delete(ProductModel productModel);

	List<ProductModel> findAll();

	List<ProductModel> findAllNewProducts();

	List<ProductModel> findAllSpecialProducts();

	List<ProductModel> findAllBestSellerProducts();

	List<ProductModel> findAllFeaturedProducts();
}

