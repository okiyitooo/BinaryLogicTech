package com.BinaryLogic.Exceptions;

public class DuplicateStudentException extends Exception {
	String message;
	public DuplicateStudentException(String format) {
		// TODO Auto-generated constructor stub
		this.message=format;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479749584723586610L;
	public String getMessage() {
		return message;
	}
}
