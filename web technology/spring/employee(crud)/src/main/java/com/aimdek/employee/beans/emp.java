package com.aimdek.employee.beans;

public class emp {  
    private int id;
    private String name;
    private String email;
//    private String address;
    private String telephone;
    public emp(String name, String email, String address, String telephone) {
		this.name = name;
		this.email = email;
//		this.address = address;
		this.telephone = telephone;
	}
	public emp() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
    
    

}
