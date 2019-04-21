package com.target.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date createdDate;
	private Date modifyedDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifyedDate() {
		return modifyedDate;
	}

	public void setModifyedDate(Date modifyedDate) {
		this.modifyedDate = modifyedDate;
	}

}
