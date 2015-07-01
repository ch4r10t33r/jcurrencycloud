package com.zincoshine.jcurrencycloud;

import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;
import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.Authentication;

public interface AuthenticateApi {
	public AuthToken beginSession(String url, String loginId, String apiKey)
			throws JCurrencyCloudException;

	public void endSession(AuthToken authToken) throws JCurrencyCloudException;
}
