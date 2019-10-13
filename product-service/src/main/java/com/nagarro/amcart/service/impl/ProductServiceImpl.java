package com.nagarro.amcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.amcart.dao.ProductDAO;
import com.nagarro.amcart.model.ProductModel;
import com.nagarro.amcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Override
	public ProductModel findProductByCode(String code) {
		return productDao.getByCode(code);
	}

	@Override
	public void save(ProductModel productModel) {
		productDao.save(productModel);
	}

	@Override
	public ProductModel get(Long id) {
		return productDao.get(id);
	}

	@Override
	public void delete(ProductModel productModel) {
		productDao.delete(productModel);
	}

	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}
	
	@Override
	public List<ProductModel> findAllNewProducts() {
		return productDao.findAllNewProducts();
	}

	@Override
	public List<ProductModel> findAllFeaturedProducts() {
		return productDao.findAllFeaturedProducts();
	}

	@Override
	public List<ProductModel> findAllBestSellerProducts() {
		return productDao.findAllBestSellerProducts();
	}

	@Override
	public List<ProductModel> findAllSpecialProducts() {
		return productDao.findAllSpecialProducts();
	}


}
