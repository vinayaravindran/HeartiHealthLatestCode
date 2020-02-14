package com.discoveri.heartihealth.exceptions;

public class HeartiException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public HeartiException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public HeartiException() {
		super();
	}

}
