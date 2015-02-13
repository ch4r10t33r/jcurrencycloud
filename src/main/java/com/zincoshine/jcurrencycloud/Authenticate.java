package com.zincoshine.jcurrencycloud;

import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;

public interface Authenticate {
	
	public String beginSession(String apiKey) throws JCurrencyCloudException;
	public void endSession(String authToken) throws JCurrencyCloudException;
}
