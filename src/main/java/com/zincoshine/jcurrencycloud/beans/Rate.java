package com.zincoshine.jcurrencycloud.beans;

import com.google.gson.Gson;

public class Rate {
	private String settlement_cut_off_time;
	private String currency_pair;
	private String client_sell_currency;
	private double client_buy_amount;
	private double client_sell_amount;
	private String fixed_side;
	private double mid_market_rate;
	private double core_rate;
	private double partner_rate;
	private double client_rate;
	private String deposit_required;
	private double deposit_amount;
	private String deposit_currency;

	public String getSettlement_cut_off_time() {
		return settlement_cut_off_time;
	}

	public String getCurrency_pair() {
		return currency_pair;
	}

	public String getClient_sell_currency() {
		return client_sell_currency;
	}

	public double getClient_buy_amount() {
		return client_buy_amount;
	}

	public double getClient_sell_amount() {
		return client_sell_amount;
	}

	public String getFixed_side() {
		return fixed_side;
	}

	public double getMid_market_rate() {
		return mid_market_rate;
	}

	public double getCore_rate() {
		return core_rate;
	}

	public double getPartner_rate() {
		return partner_rate;
	}

	public double getClient_rate() {
		return client_rate;
	}

	public String getDeposit_required() {
		return deposit_required;
	}

	public double getDeposit_amount() {
		return deposit_amount;
	}

	public String getDeposit_currency() {
		return deposit_currency;
	}

	public void setSettlement_cut_off_time(String settlement_cut_off_time) {
		this.settlement_cut_off_time = settlement_cut_off_time;
	}

	public void setCurrency_pair(String currency_pair) {
		this.currency_pair = currency_pair;
	}

	public void setClient_sell_currency(String client_sell_currency) {
		this.client_sell_currency = client_sell_currency;
	}

	public void setClient_buy_amount(double client_buy_amount) {
		this.client_buy_amount = client_buy_amount;
	}

	public void setClient_sell_amount(double client_sell_amount) {
		this.client_sell_amount = client_sell_amount;
	}

	public void setFixed_side(String fixed_side) {
		this.fixed_side = fixed_side;
	}

	public void setMid_market_rate(double mid_market_rate) {
		this.mid_market_rate = mid_market_rate;
	}

	public void setCore_rate(double core_rate) {
		this.core_rate = core_rate;
	}

	public void setPartner_rate(double partner_rate) {
		this.partner_rate = partner_rate;
	}

	public void setClient_rate(double client_rate) {
		this.client_rate = client_rate;
	}

	public void setDeposit_required(String deposit_required) {
		this.deposit_required = deposit_required;
	}

	public void setDeposit_amount(double deposit_amount) {
		this.deposit_amount = deposit_amount;
	}

	public void setDeposit_currency(String deposit_currency) {
		this.deposit_currency = deposit_currency;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}
