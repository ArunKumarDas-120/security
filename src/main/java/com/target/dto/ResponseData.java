package com.target.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseData<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;
	private String statusMessage;
	private T data;
	private List<T> listOfData;

	public ResponseData() {

	}

	public ResponseData(String status, String statusMessage) {
		this.status = status;
		this.statusMessage = statusMessage;

	}

	public ResponseData(String staus, String statusMessage, T data) {
		this.status = staus;
		this.statusMessage = statusMessage;
		this.data = data;
	}

	public String getStaus() {
		return status;
	}

	public void setStaus(String staus) {
		this.status = staus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getListOfData() {
		return listOfData;
	}

	public void setListOfData(List<T> listOfData) {
		this.listOfData = listOfData;
	}

}
