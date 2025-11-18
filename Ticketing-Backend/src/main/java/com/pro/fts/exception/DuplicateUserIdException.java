package com.pro.fts.exception;

public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(String message) {
		super(message);
	}
}
