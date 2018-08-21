package com.lgcns.ceda.dataset;

public class ClientInfo {
	
	private String division;
	private String companyName;
	private String name;
	private String position;
	private String phone;
	private String tel;
	private String role;
	private String email;
	private String service;
	private String pmInform;
	
	public ClientInfo(String division, String companyName, String name, String position, String phone, String tel, String email, String role, String pmInform, String service) {
		super();
		this.division = division;
		this.companyName = companyName;
		this.name = name;
		this.position = position;
		this.phone = phone;
		this.tel = tel;
		this.role = role;
		this.email = email;
		this.service = service;
		this.pmInform = pmInform;
	}
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPmInform() {
		return pmInform;
	}
	public void setPmInform(String pmInform) {
		this.pmInform = pmInform;
	}
	
}
