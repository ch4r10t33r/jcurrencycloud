package com.zincoshine.jcurrencycloud;

import java.util.List;
import java.util.Map;

import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;
import com.zincoshine.jcurrencycloud.vo.BalanceVO;

public interface BalancesApi {
	public void setAuthToken(AuthToken token) throws JCurrencyCloudException;

	public List<BalanceVO> findBalances(Map criteria)
			throws JCurrencyCloudException;

	public BalanceVO retrieveBalance(String currency)
			throws JCurrencyCloudException;
}
