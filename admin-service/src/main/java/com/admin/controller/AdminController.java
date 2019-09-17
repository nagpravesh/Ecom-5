package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.ProductRequest;
import com.admin.service.AdminService;
	

@RestController
@RequestMapping(path = "/product")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/createProduct" , consumes = "application/json")
	public void createProduct(@RequestBody ProductRequest productRequest)
	{
		 adminService.createProduct(productRequest);
	}
	
}
