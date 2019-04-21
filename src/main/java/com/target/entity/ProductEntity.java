package com.target.entity;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Access(AccessType.PROPERTY)
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int productId;
	private String productName;
	private String productModelNumber;
	private String productSerialNumber;
	private BigDecimal productPrice;
	private CategoryEntity catogery;
	private CompanyEntity company;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROD_ID")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "PROD_NAME", nullable = false)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PROD_MODEL_NUMBER", nullable = false)
	public String getProductModelNumber() {
		return productModelNumber;
	}

	public void setProductModelNumber(String productModelNumber) {
		this.productModelNumber = productModelNumber;
	}

	@Column(name = "PROD_SERIAL_NUMBER", nullable = false, unique = true)
	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}

	@Column(name = "PROD_PRICE", nullable = false)
	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	@ManyToOne
	@JoinColumn(name = "CAT_ID_FK", referencedColumnName = "CAT_ID")
	public CategoryEntity getCatogery() {
		return catogery;
	}

	public void setCatogery(CategoryEntity catogery) {
		this.catogery = catogery;
	}

	@ManyToOne
	@JoinColumn(name = "COMP_ID_FK", referencedColumnName = "COMP_ID")
	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

}
