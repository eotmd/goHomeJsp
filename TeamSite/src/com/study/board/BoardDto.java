package com.study.board;

import java.util.Date;

public class BoardDto {
	int boardno = 0;
	int mno = 0;
	String id = "";
	String title = "";
	String contents = "";
	Date createDate = null;
	Date modifiedDate = null;
	
	public BoardDto() {
		super();
	}
	
	
	
	public BoardDto(int boardno, String title, String id , Date createDate) {
		super();
		this.boardno = boardno;
		this.id = id;
		this.title = title;
		this.createDate = createDate;
	}



	public BoardDto(int boardno, int mno, String title, String contents, Date createDate, Date modifiedDate) {
		super();
		this.boardno = boardno;
		this.mno = mno;
		this.title = title;
		this.contents = contents;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}



	public int getBoardno() {
		return boardno;
	}



	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}



	public int getMno() {
		return mno;
	}



	public void setMno(int mno) {
		this.mno = mno;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}


	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
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
	
	
	
	
	
	
}
