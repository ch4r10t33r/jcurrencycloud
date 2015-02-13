package com.zincoshine.jcurrencycloud;

import java.util.List;
import java.util.Map;

import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;
import com.zincoshine.jcurrencycloud.vo.BalanceInfo;

public interface Balance {
	public List<BalanceInfo> findBalances(String authToken,Map criteria) throws JCurrencyCloudException; 
	public BalanceInfo retrieveBalance(String authToken,String currency) throws JCurrencyCloudException;
}
