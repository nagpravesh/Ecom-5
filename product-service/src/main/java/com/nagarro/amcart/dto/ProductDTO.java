package com.nagarro.amcart.dto;

public class ProductDTO {



	private String code;
	private String name;
	private String description;
	private String longDescription;
	private String brand;
	private Double markedPrice;
	private Double sellingPrice;
	private Long availableQuantity;
	private String primaryImageUrl;
	private String secondaryImageUrl;
	private String badge;
	private Boolean active;
	private Boolean isNew;
	private Boolean isFeatured;
	private Boolean isSpecial;
	private Boolean isBestSeller;

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

	public Double getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(Double markedPrice) {
		this.markedPrice = markedPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Long getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public void setSecondaryImageUrl(String secondaryImageUrl) {
		this.secondaryImageUrl = secondaryImageUrl;
	}

	public String getSecondaryImageUrl() {
		return secondaryImageUrl;
	}


}
