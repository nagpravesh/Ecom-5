package com.nagarro.amcart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String name;
	private String description;
	private String longDescription;
	private String brand;
	private String primaryImageUrl;
	private String secondaryImageUrl;
	private String badge;
	private Boolean active;
	private Boolean isNew;
	private Boolean isFeatured;
	private Boolean isSpecial;
	private Boolean isBestSeller;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCTMODEL_ID")
	private List<PriceModel> prices = new ArrayList<PriceModel>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "productmodel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	private List<CategoryModel> categories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}

	public String getPrimaryImageUrl() {
		return primaryImageUrl;
	}

	public void setPrimaryImageUrl(String primaryImageUrl) {
		this.primaryImageUrl = primaryImageUrl;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Boolean getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

	public Boolean getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(Boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Boolean getIsBestSeller() {
		return isBestSeller;
	}

	public void setIsBestSeller(Boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}

	public List<PriceModel> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceModel> prices) {
		this.prices = prices;
	}

	public void setSecondaryImageUrl(String secondaryImageUrl) {
		this.secondaryImageUrl = secondaryImageUrl;
	}

	public String getSecondaryImageUrl() {
		return secondaryImageUrl;
	}
}

