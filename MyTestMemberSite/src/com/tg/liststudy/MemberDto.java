package com.tg.liststudy;

import java.util.Date;

public class MemberDto {
	
	private int no = 0;       
	private String name = "";   
	private String email = "";   
	private String pasword = "";        
	private Date createDate = null; 
	private Date modifiedDate = null;
	
	
	
	public MemberDto() {
		super();
	}
	
	

	public MemberDto(int no, String name, String email, Date createDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.createDate = createDate;
	}



	public MemberDto(int no, String name, String email, String pasword, Date createDate, Date modifiedDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.pasword = pasword;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}



	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
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
	
	public String getPasword() {
		return pasword;
	}
	
	public void setPasword(String pasword) {
		this.pasword = pasword;
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
		return "MemberDto [no=" + no + ", name=" + name + ", email=" + email + ", pasword=" + pasword + ", createDate="
				+ createDate + ", modifiedDate=" + modifiedDate + "]";
	}
}
