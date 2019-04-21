package com.target.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
@Access(AccessType.PROPERTY)
public class CategoryEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int catagoryId;
	private String catagoryName;

	@Id
	@Column(name = "CAT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}

	@Column(name = "CAT_NAME", nullable = false, unique = true)
	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

}
