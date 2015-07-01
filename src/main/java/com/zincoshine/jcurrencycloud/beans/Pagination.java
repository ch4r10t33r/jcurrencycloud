package com.zincoshine.jcurrencycloud.beans;

public class Pagination {
	private String total_entries;
	private String total_pages;
	private String current_page;
	private String per_page;
	private String previous_page;
	private String next_page;
	private String order;
	private String order_asc_desc;
	public String getTotal_entries() {
		return total_entries;
	}
	public String getTotal_pages() {
		return total_pages;
	}
	public String getCurrent_page() {
		return current_page;
	}
	public String getPer_page() {
		return per_page;
	}
	public String getPrevious_page() {
		return previous_page;
	}
	public String getNext_page() {
		return next_page;
	}
	public String getOrder() {
		return order;
	}
	public String getOrder_asc_desc() {
		return order_asc_desc;
	}
	public void setTotal_entries(String total_entries) {
		this.total_entries = total_entries;
	}
	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}
	public void setCurrent_page(String current_page) {
		this.current_page = current_page;
	}
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
	public void setPrevious_page(String previous_page) {
		this.previous_page = previous_page;
	}
	public void setNext_page(String next_page) {
		this.next_page = next_page;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public void setOrder_asc_desc(String order_asc_desc) {
		this.order_asc_desc = order_asc_desc;
	}
}
