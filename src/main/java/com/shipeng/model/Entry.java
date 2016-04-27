package com.shipeng.model;

public class Entry {
	
	private int id;
	private String title;
	private String text;
	private int posted_timestamp;
	private int category;

	public Entry() {
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int value) {
		this.id = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getText() {
		return this.text;
	}

	public void setText(String value) {
		this.text = value;
	}

	public int getPosted_timestamp() {
		return this.posted_timestamp;
	}

	public void setPosted_timestamp(int value) {
		this.posted_timestamp = value;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int value) {
		this.category = value;
	}
	
}//end class Entry
