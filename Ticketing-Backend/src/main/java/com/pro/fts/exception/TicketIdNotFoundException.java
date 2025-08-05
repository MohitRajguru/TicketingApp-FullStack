package com.pro.fts.exception;

public class TicketIdNotFoundException extends RuntimeException {
	public TicketIdNotFoundException(String message) {
		super(message);
	}
}