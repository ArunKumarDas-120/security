package com.target.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseData<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String staus;
	private String stausMessage;
	private T data;
	private List<T> listOfData;

	public ResponseData() {

	}

	public ResponseData(String staus, String stausMessage) {
		this.staus = staus;
		this.stausMessage = stausMessage;

	}

	public ResponseData(String staus, String stausMessage, T data) {
		this.staus = staus;
		this.stausMessage = stausMessage;
		this.data = data;
	}

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}

	public String getStausMessage() {
		return stausMessage;
	}

	public void setStausMessage(String stausMessage) {
		this.stausMessage = stausMessage;
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
