package com.zincoshine.jcurrencycloud;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.Conversion;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;

public interface ConversionsApi {
	public Conversion createConversion(String buyCurrency, String sellCurrency,
			String fixedSide, double amount, String reason,
			String termAgreement, Date conversionDate, double clientBuyAmount,
			double clientSellAmount, String onBehalfOf)
			throws JCurrencyCloudException;
	public List<Conversion> findConversion(Map<String,String> params) throws JCurrencyCloudException;
	public Conversion getConversion(String id) throws JCurrencyCloudException;
	public void setAuthToken(AuthToken token) throws JCurrencyCloudException;
}
