package com.zincoshine.jcurrencycloud;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.BidAskRate;
import com.zincoshine.jcurrencycloud.beans.Rate;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;

public interface RatesApi {
	public Rate findDetailedRates(String buyCurrency, String sellCurrency,
			String fixedSide, double amount, Date conversionDate,
			String onBehalfOf) throws JCurrencyCloudException;

	public Map<String, BidAskRate> findRates(List<String> currencyPair)
			throws JCurrencyCloudException;

	public void setAuthToken(AuthToken token) throws JCurrencyCloudException;
}
