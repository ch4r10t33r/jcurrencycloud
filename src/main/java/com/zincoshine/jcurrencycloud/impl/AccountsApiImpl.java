/**
 * 
 */
package com.zincoshine.jcurrencycloud.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.zincoshine.jcurrencycloud.AccountsApi;
import com.zincoshine.jcurrencycloud.exception.JCurrencyCloudException;
import com.zincoshine.jcurrencycloud.vo.AccountVO;
import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.Account;

/**
 * @author thambu
 *
 */
public class AccountsApiImpl implements AccountsApi {

	/* (non-Javadoc)
	 * @see com.zincoshine.jcurrencycloud.AccountsApi#createAccount(java.lang.String, java.lang.String, com.zincoshine.jcurrencycloud.vo.Account)
	 */
	public Account createAccount(String url, String authToken,
			AccountVO theAccount) throws JCurrencyCloudException {
		Account newAccount = null;
		try {
			Gson gson = new Gson();
			
			HttpClient httpClient = new DefaultHttpClient();
			List<NameValuePair> params = new LinkedList<NameValuePair>();
			
			params.add(new BasicNameValuePair("account_name",theAccount.getAccountName()));
			
			if(theAccount.getLegalEntityType() != null) {
				params.add(new BasicNameValuePair("legal_entity_type",theAccount.getLegalEntityType()));
			}
			if(theAccount.getYourRef() != null) {
				params.add(new BasicNameValuePair("your_reference",theAccount.getYourRef()));
			}
			if(theAccount.getStatus() != null) {
				params.add(new BasicNameValuePair("status",theAccount.getStatus()));
			}
			if(theAccount.getStreet() != null) {
				params.add(new BasicNameValuePair("street",theAccount.getStreet()));
			}
			if(theAccount.getCity() != null) {
				params.add(new BasicNameValuePair("city",theAccount.getCity()));
			}
			if(theAccount.getStateOrProvince() != null) {
				params.add(new BasicNameValuePair("state_or_province",theAccount.getStateOrProvince()));
			}
			if(theAccount.getPostalCode() != null) {
				params.add(new BasicNameValuePair("postal_code",theAccount.getPostalCode()));
			}
			if(theAccount.getCountry() != null) {
				params.add(new BasicNameValuePair("country",theAccount.getCountry()));
			}
			if(theAccount.getSpreadTable() != null) {
				params.add(new BasicNameValuePair("spread_table",theAccount.getSpreadTable()));
			}
			if(theAccount.getIdentificationType() != null) {
				params.add(new BasicNameValuePair("identification_type",theAccount.getIdentificationType()));
			}
			if(theAccount.getIdentificationValue() != null) {
				params.add(new BasicNameValuePair("identification_value",theAccount.getIdentificationValue()));
			}
			
			HttpPost httpPost = new HttpPost(url+"accounts/create");
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			
			httpPost.addHeader("X-Auth-Token", authToken);
			
			
			Header[] headers =  httpPost.getAllHeaders();
			System.out.println("Request: ");
			for(int i=0;i<headers.length;i++) {
				System.out.println(headers[i].getName() + ":" + headers[i].getValue());
			}
			System.out.println(" " + httpPost);
			System.out.println();
			
			HttpResponse response = httpClient.execute(httpPost);
			
			System.out.println("Status Line: " + response.getStatusLine());
			System.out.println("Status Code: " + response.getStatusLine().getStatusCode());
			
			if (response.getStatusLine().getStatusCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while((line = br.readLine()) != null) {
					System.out.println(line);
					sb.append(line);
				}
				newAccount = gson.fromJson(sb.toString(),Account.class);
			}
			
			httpClient.getConnectionManager().shutdown();			
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new JCurrencyCloudException(e.toString());
		}
		return newAccount;
	}

	/* (non-Javadoc)
	 * @see com.zincoshine.jcurrencycloud.AccountsApi#retriveAccount(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Account retriveAccount(String url, String authToken, String id)
			throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.zincoshine.jcurrencycloud.AccountsApi#findAll(java.lang.String, java.lang.String)
	 */
	public List<Account> findAll(String url, String authToken)
			throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.zincoshine.jcurrencycloud.AccountsApi#updateAccount(java.lang.String, java.lang.String, java.lang.String, com.zincoshine.jcurrencycloud.vo.Account)
	 */
	public Account updateAccount(String url, String authToken, String id,
			AccountVO newAccount) throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.zincoshine.jcurrencycloud.AccountsApi#getCurrentAccount(java.lang.String, java.lang.String)
	 */
	public Account getCurrentAccount(String url, String authToken)
			throws JCurrencyCloudException {
		// TODO Auto-generated method stub
		return null;
	}

}
