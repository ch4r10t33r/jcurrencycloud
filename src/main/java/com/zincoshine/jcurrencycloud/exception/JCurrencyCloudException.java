package com.zincoshine.jcurrencycloud.exception;

public class JCurrencyCloudException extends Exception {
	private String err;

	public JCurrencyCloudException() {
		super();
	}

	public JCurrencyCloudException(String err) {
		this.err = err;
	}
}
