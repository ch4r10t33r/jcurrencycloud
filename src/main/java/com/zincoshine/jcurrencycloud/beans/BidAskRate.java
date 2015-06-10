package com.zincoshine.jcurrencycloud.beans;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class BidAskRate {
	private String currencyPair;
	private double bid;
	private double ask;
	
	public String getCurrencyPair() {
		return currencyPair;
	}
	public double getBid() {
		return bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	public String toString() {
		return new Gson().toJson(this);
	}
}
