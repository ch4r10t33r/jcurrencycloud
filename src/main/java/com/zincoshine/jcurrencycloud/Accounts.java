package com.zincoshine.jcurrencycloud;

import java.util.List;

import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;
import com.zincoshine.jcurrencycloud.vo.AccountInfo;

public interface Accounts {
	public AccountInfo createAccount(String authToken,String accountName) throws JCurrencyCloudException;
	public AccountInfo retriveAccount(String authToken,String id) throws JCurrencyCloudException;
	public List<AccountInfo> findAll(String authToken) throws JCurrencyCloudException;
	public AccountInfo updateAccount(String authToken,String id,AccountInfo newAccount) throws JCurrencyCloudException;
	public AccountInfo getCurrentAccount(String authToken) throws JCurrencyCloudException;
	
}
