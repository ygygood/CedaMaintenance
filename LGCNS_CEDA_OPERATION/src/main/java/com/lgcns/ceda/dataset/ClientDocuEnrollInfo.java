package com.lgcns.ceda.dataset;

public class ClientDocuEnrollInfo {
	
	private String company_name;
	private String ip;
	private String error_msg;
	private String creation_date;
	private String all_msg;
	
	public ClientDocuEnrollInfo(String company_name, String ip, String error_msg, String creation_date, String all_msg) {
		this.company_name = company_name;
		this.error_msg = error_msg;
		this.creation_date = creation_date;
		this.ip = ip;
		this.all_msg = all_msg;
	}
	
	public String getCompany_name() {
		return company_name;
	}
	public String getError_msg() {
		return error_msg;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public String getIp() {
		return ip;
	}
	public String getAll_msg() {
		return all_msg;
	}
}
