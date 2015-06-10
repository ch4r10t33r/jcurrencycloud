package com.zincoshine.jcurrencycloud;

import java.util.List;

import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;
import com.zincoshine.jcurrencycloud.vo.AccountVO;
import com.zincoshine.jcurrencycloud.beans.Account;

public interface AccountsApi {
	public Account createAccount(String url,String authToken,AccountVO theAccount) throws JCurrencyCloudException;
	public Account retriveAccount(String url,String authToken,String id) throws JCurrencyCloudException;
	public List<Account> findAll(String url,String authToken) throws JCurrencyCloudException;
	public Account updateAccount(String url,String authToken,String id,AccountVO newAccount) throws JCurrencyCloudException;
	public Account getCurrentAccount(String url,String authToken) throws JCurrencyCloudException;
	
}
