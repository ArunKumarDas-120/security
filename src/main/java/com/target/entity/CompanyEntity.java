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
@Table(name = "COMPANY")
@Access(AccessType.PROPERTY)
public class CompanyEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int companyId;
	private String companyName;

	@Id
	@Column(name = "COMP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMP_NAME", nullable = false, unique = true)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
