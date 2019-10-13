package com.nagarro.amcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.amcart.dto.ProductDTO;
import com.nagarro.amcart.model.ProductModel;
import com.nagarro.amcart.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/product/{productCode}")
	public ProductDTO getProductByCode(@PathVariable String productCode)
	{
		return convertEntityToDTo(productService.findProductByCode(productCode));
	}

	private ProductDTO convertEntityToDTo(ProductModel source) {
		ProductDTO target = new ProductDTO();
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setLongDescription(source.getLongDescription());
		target.setBrand(source.getBrand());
		target.setIsNew(source.getIsNew());
		target.setIsFeatured(source.getIsFeatured());
		target.setIsBestSeller(source.getIsBestSeller());
		target.setIsSpecial(source.getIsSpecial());
		target.setBadge(source.getBadge());
		target.setPrimaryImageUrl(source.getPrimaryImageUrl());
		target.setSecondaryImageUrl(source.getSecondaryImageUrl());
		return target;
	}
	
}
