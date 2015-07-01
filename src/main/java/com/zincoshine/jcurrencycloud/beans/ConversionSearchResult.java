package com.zincoshine.jcurrencycloud.beans;

import java.util.List;

public class ConversionSearchResult {
	private List<Conversion> conversions;
	private Pagination pagination;
	public List<Conversion> getConversions() {
		return conversions;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setConversions(List<Conversion> conversions) {
		this.conversions = conversions;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
}
