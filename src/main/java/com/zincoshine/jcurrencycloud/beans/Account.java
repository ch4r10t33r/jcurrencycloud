package com.zincoshine.jcurrencycloud.beans;

import com.google.gson.Gson;

public class Account {
	
	private String id;
	private String legal_entity_type;
	private String account_type;
	private String brand;
	private String your_reference;
	private String status;
	private String street;
	private String city;
	private String country;
	private String postal_code;
	private String spread_table;
	private String created_at;
	private String updated_at;
	private String identification_type;
	private String identification_value;
	public String getId() {
		return id;
	}
	public String getLegal_entity_type() {
		return legal_entity_type;
	}
	public String getAccount_type() {
		return account_type;
	}
	public String getBrand() {
		return brand;
	}
	public String getYour_reference() {
		return your_reference;
	}
	public String getStatus() {
		return status;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public String getSpread_table() {
		return spread_table;
	}
	public String getCreated_at() {
		return created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public String getIdentification_type() {
		return identification_type;
	}
	public String getIdentification_value() {
		return identification_value;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLegal_entity_type(String legal_entity_type) {
		this.legal_entity_type = legal_entity_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setYour_reference(String your_reference) {
		this.your_reference = your_reference;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public void setSpread_table(String spread_table) {
		this.spread_table = spread_table;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public void setIdentification_type(String identification_type) {
		this.identification_type = identification_type;
	}
	public void setIdentification_value(String identification_value) {
		this.identification_value = identification_value;
	}
	public String toString() {
		return new Gson().toJson(this);
	}
}
