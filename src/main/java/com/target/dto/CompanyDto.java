package com.target.dto;

public class CompanyDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private int companyId;
	private String companyName;

	public int getCompnayId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
