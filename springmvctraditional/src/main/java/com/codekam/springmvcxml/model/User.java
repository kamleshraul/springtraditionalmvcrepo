package com.codekam.springmvcxml.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String guid;
	
	@Size(min=4 ,message = "Enter atleast 4 characters")
	private String name;
	@Size(min=4 ,message = "Enter atleast 4 characters")
	private String userId;
	@Size(min=4 ,message = "Enter atleast 4 characters")
	private String password;
	@Size(min=4 ,message = "Enter atleast 4 characters")
	private String password2;
	
	@Max(value = 10, message="Enter value less than 10")
	private Integer amount;
	
	private String country;
	
	
	private Date birthDate;

	@AssertTrue(message="Password fields don't match" )
	private boolean isValid() {
		return this.password.equals(this.password2);
	}
	
	
	public User() {
		super();
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public String toString() {
		return "User [guid=" + guid + ", name=" + name + ", userId=" + userId + ", password=" + password
				+ ", password2=" + password2 + ", amount=" + amount + ", country=" + country + ", birthDate="
				+ birthDate + "]";
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
