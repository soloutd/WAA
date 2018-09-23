package edu.mum.cs545.model.dto;

public class DomainError {
	private String message;

	public DomainError() {
	}

	public DomainError(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
