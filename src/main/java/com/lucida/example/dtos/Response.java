package com.lucida.example.dtos;


public class Response {

	private int statusCode;
	private String description;
	private String status;

	public Response(int statusCode, String description, String status) {
		this.statusCode = statusCode;
		this.description = description;
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
