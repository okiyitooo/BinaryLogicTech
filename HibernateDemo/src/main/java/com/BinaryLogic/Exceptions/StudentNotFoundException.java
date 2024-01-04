package com.BinaryLogic.Exceptions;

public class StudentNotFoundException extends Exception {
	private String message;
	public StudentNotFoundException(String format) {
		// TODO Auto-generated constructor stub
		this.message = format;
	}
	public String getMessage() {
		return message;
	}

}
