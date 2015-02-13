package com.zincoshine.jcurrencycloud.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class JCurrencyConfig {
	private Properties theFile;
	private String executionMode;
	private String prodUrl;
	private String demoUrl;
	private String apiKey;
	
	private JCurrencyConfig() {
		try {
			theFile = new Properties();
			System.out.println(getClass().getClassLoader().getResource("jcurrencycloud.properties").toURI());
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("jcurrencycloud.properties");
			if(inputStream != null) {
				theFile.load(inputStream);
			}
			else {
				throw new FileNotFoundException("Property File: jcurrencycloud.properties not found in classpath!");
			}
			executionMode = theFile.getProperty("execution_mode");
			prodUrl = theFile.getProperty("prod_url");
			demoUrl = theFile.getProperty("demo_url");
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
	
	public static void main(String []a) throws Exception{
		JCurrencyConfig theConfig = JCurrencyConfig.newInstance();
		System.out.println("API: " + theConfig.getApiKey());
	}
}
