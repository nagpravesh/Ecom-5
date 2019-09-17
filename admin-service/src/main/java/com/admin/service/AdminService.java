package com.admin.service;

import org.springframework.stereotype.Service;

import com.admin.dto.ProductRequest;


public interface AdminService {
	
	void createProduct(ProductRequest productRequest);

}
