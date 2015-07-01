package com.zincoshine.jcurrencycloud.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.joda.time.DateTime;

import sun.org.mozilla.javascript.internal.json.JsonParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.zincoshine.jcurrencycloud.RatesApi;
import com.zincoshine.jcurrencycloud.beans.Account;
import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.BidAskRate;
import com.zincoshine.jcurrencycloud.beans.Rate;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;

public class RatesApiImpl implements RatesApi {

	private AuthToken token;

	public Rate findDetailedRates(String buyCurrency, String sellCurrency,
			String fixedSide, double amount, Date conversionDate,
			String onBehalfOf) throws JCurrencyCloudException {
		Rate rate = null;
		if (token != null) {
			try {
				HttpClient httpClient = new DefaultHttpClient();
				StringBuffer queryString = new StringBuffer();
				queryString.append("buy_currency=").append(
						URLEncoder.encode(buyCurrency, "UTF-8"));
				queryString.append("&sell_currency=").append(
						URLEncoder.encode(sellCurrency, "UTF-8"));
				queryString.append("&fixed_side=").append(
						URLEncoder.encode(fixedSide, "UTF-8"));
				queryString.append("&amount=").append(
						URLEncoder.encode(amount + "", "UTF-8"));
				if (conversionDate != null) {
					queryString.append("&conversion_date=").append(
							URLEncoder.encode(new DateTime(conversionDate)
									.toString("YYYY-MM-DD"), "UTF-8"));
				}
				if (onBehalfOf != null) {
					queryString.append("&on_behalf_of=").append(
							URLEncoder.encode(onBehalfOf, "UTF-8"));
				}

				HttpGet httpGet = new HttpGet(token.getUrl()
						+ "rates/detailed?" + queryString.toString());

				// System.out.println(httpGet.getRequestLine());
				httpGet.addHeader("X-Auth-Token", token.getAuthToken());

				HttpResponse response = httpClient.execute(httpGet);
				// System.out.println(response.getStatusLine());

				if (response.getStatusLine().getStatusCode() == 200) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(
									(response.getEntity().getContent())));
					StringBuffer sb = new StringBuffer();
					String line = null;
					while ((line = br.readLine()) != null) {
						sb.append(line);
					}
					rate = new Gson().fromJson(sb.toString(), Rate.class);
				}

				httpClient.getConnectionManager().shutdown();

			} catch (Exception e) {
				// e.printStackTrace();
				throw new JCurrencyCloudException(e.getMessage());
			}
		} else {
			throw new JCurrencyCloudException("Authenication is invalid!!");
		}
		return rate;
	}

	public Map<String, BidAskRate> findRates(List<String> currencyPair)
			throws JCurrencyCloudException {
		String jsonOutput = null;
		Map<String, BidAskRate> ratesMap = null;
		if (token != null) {
			try {
				HttpClient httpClient = new DefaultHttpClient();
				String queryString = StringUtils.join(currencyPair).trim()
						.replaceAll("[\\[\\]\\s]", "");

				HttpGet httpGet = new HttpGet(token.getUrl()
						+ "rates/find?currency_pair="
						+ URLEncoder.encode(queryString, "UTF-8"));

				httpGet.addHeader("X-Auth-Token", token.getAuthToken());

				HttpResponse response = httpClient.execute(httpGet);

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
					ratesMap = new HashMap<String, BidAskRate>();
					// System.out.println("Before Conversion: "+ jsonOutput);
					JsonObject obj = new Gson().fromJson(jsonOutput,
							JsonObject.class);

					JsonObject ratesObject = obj.get("rates").getAsJsonObject();
					Set set = ratesObject.entrySet();
					Iterator iterator = set.iterator();
					while (iterator.hasNext()) {
						Object ratesData = iterator.next();
						String[] keyValuePair = ratesData.toString().split("=");
						if (keyValuePair.length == 2) {
							BidAskRate rate = new BidAskRate();
							rate.setCurrencyPair(keyValuePair[0]);
							List<String> bidAskRates = Arrays
									.asList(keyValuePair[1]
											.replaceAll("[\\[\\]\\s]", "")
											.replaceAll("\"", "").split(","));
							if (bidAskRates.size() == 2) {
								rate.setBid(Double.valueOf(bidAskRates.get(0)));
								rate.setAsk(Double.valueOf(bidAskRates.get(1)));
							}
							ratesMap.put(rate.getCurrencyPair(), rate);
						}
					}
				}
				// System.out.println(new Gson().toJson(ratesMap));
				httpClient.getConnectionManager().shutdown();

			} catch (Exception e) {
				e.printStackTrace();
				throw new JCurrencyCloudException(e.getMessage());
			}
		} else {
			throw new JCurrencyCloudException("Authenication is invalid!!");
		}
		return ratesMap;
	}

	public void setAuthToken(AuthToken token) throws JCurrencyCloudException {
		this.token = token;
	}

}
