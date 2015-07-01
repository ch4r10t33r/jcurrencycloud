package com.zincoshine.jcurrencycloud.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.zincoshine.jcurrencycloud.ConversionsApi;
import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.Conversion;
import com.zincoshine.jcurrencycloud.beans.ConversionSearchResult;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;

public class ConversionsApiImpl implements ConversionsApi {
	private AuthToken token;
	
	public Conversion createConversion(String buyCurrency, String sellCurrency,
			String fixedSide, double amount, String reason,
			String termAgreement, Date conversionDate, double clientBuyAmount,
			double clientSellAmount, String onBehalfOf)
			throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Conversion> findConversion(Map<String, String> params)
			throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		List<Conversion> conversions = null;
		String jsonOutput = null;
		try {
			if(params != null) {
				Set<String> keys = params.keySet();
				Iterator keysIterator = keys.iterator();
				StringBuffer queryString = new StringBuffer("");
				while(keysIterator.hasNext()) {
					if(!queryString.toString().equals("")) {
						queryString.append("&");
					}
					String theKey = (String) keysIterator.next();
					queryString.append(theKey+"="+URLEncoder.encode(params.get(theKey),"UTF-8"));
				}
				System.out.println("URL: " + token.getUrl() + "conversions/find?" + queryString.toString());
				
				HttpClient httpClient = new DefaultHttpClient();
	
				HttpGet httpGet = new HttpGet(token.getUrl()
						+ "conversions/find?"
						+ queryString.toString());
	
				httpGet.addHeader("X-Auth-Token", token.getAuthToken());
	
				HttpResponse response = httpClient.execute(httpGet);
				System.out.println("Response: " + response.getStatusLine());
				if (response.getStatusLine().getStatusCode() == 200) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(
									(response.getEntity().getContent())));
					StringBuffer sb = new StringBuffer();
					String line = null;
					while ((line = br.readLine()) != null) {
						sb.append(line);
					}
					jsonOutput = sb.toString();
					System.out.println(jsonOutput);
					ConversionSearchResult searchResult = new Gson().fromJson(jsonOutput, ConversionSearchResult.class);
					conversions = searchResult.getConversions();
				}
			}	
		} catch(Exception e) {
			throw new JCurrencyCloudException(e.getMessage());
		}
		return conversions;
	}

	public Conversion getConversion(String id) throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAuthToken(AuthToken token) throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		this.token = token;		
	}

}
