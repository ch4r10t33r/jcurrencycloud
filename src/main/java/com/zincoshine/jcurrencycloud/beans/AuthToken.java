package com.zincoshine.jcurrencycloud.beans;

import com.google.gson.Gson;

public class AuthToken {

	private String authToken;
	private String url;

	public String getAuthToken() {
		return authToken;
	}

	public String getUrl() {
		return url;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}
