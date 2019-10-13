package com.nagarro.amcart.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.amcart.dao.ProductDAO;
import com.nagarro.amcart.model.ProductModel;
import com.nagarro.amcart.repository.ProductRepository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void save(ProductModel productModel){
		productRepository.saveAndFlush(productModel);
	}
	
	@Override
	public ProductModel get(Long id){
		return productRepository.getOne(id);
	}

	@Override
	public ProductModel getByCode(String code) {
		return productRepository.findByCode(code);
	}

	@Override
	public void delete(ProductModel productModel) {
		productRepository.delete(productModel);
	}

	@Override
	public List<ProductModel> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductModel> findAllNewProducts() {
		return productRepository.findByIsNew(Boolean.TRUE);
	}

	@Override
	public List<ProductModel> findAllFeaturedProducts() {
		return productRepository.findByIsFeatured(Boolean.TRUE);
	}

	@Override
	public List<ProductModel> findAllBestSellerProducts() {
		return productRepository.findByIsBestSeller(Boolean.TRUE);
	}

	@Override
	public List<ProductModel> findAllSpecialProducts() {
		return productRepository.findByIsSpecial(Boolean.TRUE);
	}
	
}
