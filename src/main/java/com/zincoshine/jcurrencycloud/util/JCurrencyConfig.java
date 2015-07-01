package com.zincoshine.jcurrencycloud.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.zincoshine.jcurrencycloud.AccountsApi;
import com.zincoshine.jcurrencycloud.AuthenticateApi;
import com.zincoshine.jcurrencycloud.ConversionsApi;
import com.zincoshine.jcurrencycloud.RatesApi;
import com.zincoshine.jcurrencycloud.impl.AccountsApiImpl;
import com.zincoshine.jcurrencycloud.impl.AuthenticateApiImpl;
import com.zincoshine.jcurrencycloud.impl.ConversionsApiImpl;
import com.zincoshine.jcurrencycloud.impl.RatesApiImpl;
import com.zincoshine.jcurrencycloud.vo.AccountVO;
import com.zincoshine.jcurrencycloud.beans.Account;
import com.zincoshine.jcurrencycloud.beans.AuthToken;
import com.zincoshine.jcurrencycloud.beans.BidAskRate;
import com.zincoshine.jcurrencycloud.beans.Conversion;

public class JCurrencyConfig {
	private Properties theFile;
	private String executionMode;
	private String prodUrl;
	private String demoUrl;
	private String loginId;
	private String apiKey;

	private JCurrencyConfig() {
		try {
			theFile = new Properties();
			System.out.println(getClass().getClassLoader()
					.getResource("jcurrencycloud.properties").toURI());
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("jcurrencycloud.properties");
			if (inputStream != null) {
				theFile.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"Property File: jcurrencycloud.properties not found in classpath!");
			}
			executionMode = theFile.getProperty("execution_mode");
			prodUrl = theFile.getProperty("prod_url");
			demoUrl = theFile.getProperty("demo_url");
			loginId = theFile.getProperty("login_id");
			apiKey = theFile.getProperty("api_key");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JCurrencyConfig newInstance() throws Exception {
		return new JCurrencyConfig();
	}

	public String getExecutionMode() {
		return executionMode;
	}

	public String getProdUrl() {
		return prodUrl;
	}

	public String getDemoUrl() {
		return demoUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getLoginId() {
		return loginId;
	}

	public static void main(String[] a) throws Exception {
		JCurrencyConfig theConfig = JCurrencyConfig.newInstance();
		System.out.println("API: " + theConfig.getApiKey());
		AuthenticateApi authenticate = new AuthenticateApiImpl();
		AuthToken authToken = authenticate.beginSession(theConfig.getDemoUrl(),
				theConfig.getLoginId(), theConfig.getApiKey());

		System.out.println(authToken);
		/*
		 * AccountsApi accounts = new AccountsApiImpl(); AccountVO theAccount =
		 * new AccountVO(); theAccount.setAccountName("Test Account");
		 * theAccount.setLegalEntityType("company");
		 * theAccount.setIdentificationType("company-1");
		 * theAccount.setIdentificationValue("company-1");
		 * theAccount.setCity("Test"); theAccount.setCountry("GB");
		 * theAccount.setPostalCode("test");
		 * theAccount.setStateOrProvince("test"); theAccount.setStreet("test");
		 * theAccount.setSpreadTable("test"); theAccount.setStatus("Active");
		 * theAccount.setYourRef("my-ref-1"); Account newAccount =
		 * accounts.createAccount(theConfig.getDemoUrl(), authToken.getToken(),
		 * theAccount); System.out.println(newAccount);
		 */
		/*RatesApi rates = new RatesApiImpl();
		rates.setAuthToken(authToken);

		ArrayList<String> currencyPairs = new ArrayList<String>();
		currencyPairs.add("EURUSD");
		currencyPairs.add("EURGBP");
		currencyPairs.add("GBPUSD");
		//Map<String, BidAskRate> rate = rates.findRates(currencyPairs);
		// System.out.println(jsonOutput);
*/		
		ConversionsApi conversionApi = new ConversionsApiImpl();
		conversionApi.setAuthToken(authToken);
		Map<String,String> params = new HashMap<String,String>();
		params.put("status","awaiting_funds");
		List<Conversion> conversion = conversionApi.findConversion(params);
		// System.out.println(rates.findDetailedRates("USD", "EUR", "buy", 100,
		// null, null));
		authenticate.endSession(authToken);
	}
}
