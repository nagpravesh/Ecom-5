package com.nagarro.amcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.amcart.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

	ProductModel findByCode(String code);
	
	/**
     * Finds all NEW products.
     * @return  A list of product where isNew flag is true.
     *          If no product is found, this method returns an empty list.
     */
    public List<ProductModel> findByIsNew(Boolean isNew);
    
    /**
     * Finds all Special products.
     * @return  A list of product where isSpecial flag is true.
     *          If no product is found, this method returns an empty list.
     */
    public List<ProductModel> findByIsSpecial(Boolean isSpecial);
    
    /**
     * Finds all FEATURED products.
     * @return  A list of product where isFeatured flag is true.
     *          If no product is found, this method returns an empty list.
     */
    public List<ProductModel> findByIsFeatured(Boolean isFeatured);
    
    /**
     * Finds all BEST SELLER products.
     * @return  A list of product where isBestSeller flag is true.
     *          If no product is found, this method returns an empty list.
     */
    public List<ProductModel> findByIsBestSeller(Boolean isBestSeller);
}

