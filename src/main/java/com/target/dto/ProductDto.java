package com.target.dto;

import java.math.BigDecimal;

public class ProductDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private int productId;
	private String productName;
	private String productModelNumber;
	private String productSerialNumber;
	private BigDecimal productPrice;
	private CategoryDto catogery;
	private CompanyDto company;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModelNumber() {
		return productModelNumber;
	}

	public void setProductModelNumber(String productModelNumber) {
		this.productModelNumber = productModelNumber;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public CategoryDto getCatogery() {
		return catogery;
	}

	public void setCatogery(CategoryDto catogery) {
		this.catogery = catogery;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

}
