package com.zincoshine.jcurrencycloud;

public interface Authenticate {
	
	public String beginSession(String apiKey);
	public String endSession(String authToken);
}
