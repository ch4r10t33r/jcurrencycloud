package com.zincoshine.jcurrencycloud.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.zincoshine.jcurrencycloud.util.JCurrencyConfig;
import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.Authentication;
import com.zincoshine.jcurrencycloud.AuthenticateApi;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;

public class AuthenticateApiImpl implements AuthenticateApi {

	public AuthToken beginSession(String url, String loginId, String apiKey)
			throws JCurrencyCloudException {

		Authentication auth = null;
		AuthToken authToken = null;

		try {
			Gson gson = new Gson();

			HttpClient httpClient = new DefaultHttpClient();
			List<NameValuePair> params = new LinkedList<NameValuePair>();

			params.add(new BasicNameValuePair("login_id", loginId));
			params.add(new BasicNameValuePair("api_key", apiKey));

			HttpPost httpPost = new HttpPost(url + "/authenticate/api");
			httpPost.setEntity(new UrlEncodedFormEntity(params));

			httpPost.addHeader("User-Agent", "HTTP/1.1");

			HttpResponse response = httpClient.execute(httpPost);

			if (response.getStatusLine().getStatusCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				auth = gson.fromJson(sb.toString(), Authentication.class);
				if (auth != null) {
					authToken = new AuthToken();
					authToken.setAuthToken(auth.getToken());
					authToken.setUrl(url);
				}
			}

			httpClient.getConnectionManager().shutdown();

		} catch (Exception e) {
			throw new JCurrencyCloudException(e.toString());
		}
		return authToken;
	}

	public void endSession(AuthToken authToken) throws JCurrencyCloudException {
		try {

			HttpClient httpClient = new DefaultHttpClient();

			HttpPost httpPost = new HttpPost(authToken.getUrl());
			httpPost.addHeader("X-Auth-Token", authToken.getAuthToken());
			// httpPost.addHeader("User-Agent", "HTTP/1.1");

			HttpResponse response = httpClient.execute(httpPost);

			if (response.getStatusLine().getStatusCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			}

			httpClient.getConnectionManager().shutdown();

		} catch (Exception e) {
			throw new JCurrencyCloudException(e.toString());
		}
	}
}
