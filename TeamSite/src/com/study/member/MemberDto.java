package com.study.member;

import java.util.Date;

public class MemberDto {
	
	private	int mno = 0;              
	private	String name = ""; 
	private	String email = ""; 
	private	String password = ""; 
	private	Date createDate = null;
	private	Date modifiedDate = null;
	
	public MemberDto() {
		super();
	}
	
	
	
	public MemberDto(int mno, String name, String email, Date createDate) {
		super();
		this.mno = mno;
		this.name = name;
		this.email = email;
		this.createDate = createDate;
	}

	public MemberDto(int mno, String name, String email, String password, Date createDate, Date modifiedDate) {
		super();
		this.mno = mno;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

	public MemberDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public MemberDto(String name, String email, int mno) {
		super();
		this.name = name;
		this.email = email;
		this.mno = mno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
