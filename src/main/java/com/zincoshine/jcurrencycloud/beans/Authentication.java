package com.zincoshine.jcurrencycloud.beans;

import com.google.gson.Gson;

public class Authentication {

	private String auth_token;

	public String getToken() {
		return auth_token;
	}

	public void setToken(String authToken) {
		this.auth_token = authToken;
	}
	
	public boolean equals(Authentication token) {
		return this.auth_token.equals(token.getToken());
	}
	
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
