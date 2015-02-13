package com.zincoshine.jcurrencycloud.vo;

import java.util.Date;

public class AccountInfo {
	
	private String id;
	private String legalEntityType;
	private String accountType;
	private String brand;
	private String yourRef;
	private String status;
	private String street;
	private String city;
	private String country;
	private String postalCode;
	private String spreadTable;
	private Date createdDate;
	private Date updatedDate;
	private String identificationType;
	private String identificationValue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLegalEntityType() {
		return legalEntityType;
	}
	public void setLegalEntityType(String legalEntityType) {
		this.legalEntityType = legalEntityType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getYourRef() {
		return yourRef;
	}
	public void setYourRef(String yourRef) {
		this.yourRef = yourRef;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getSpreadTable() {
		return spreadTable;
	}
	public void setSpreadTable(String spreadTable) {
		this.spreadTable = spreadTable;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	public String getIdentificationValue() {
		return identificationValue;
	}
	public void setIdentificationValue(String identificationValue) {
		this.identificationValue = identificationValue;
	}
}
