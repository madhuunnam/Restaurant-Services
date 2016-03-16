package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * Choices generated by hbm2java
 */
public class Choices implements java.io.Serializable {

	private ChoicesId id;
	private String chTitle;
	private String chType;
	private Boolean required;
	private Byte numValue;

	public Choices() {
	}

	public Choices(ChoicesId id) {
		this.id = id;
	}

	public Choices(ChoicesId id, String chTitle, String chType, Boolean required, Byte numValue) {
		this.id = id;
		this.chTitle = chTitle;
		this.chType = chType;
		this.required = required;
		this.numValue = numValue;
	}

	public ChoicesId getId() {
		return this.id;
	}

	public void setId(ChoicesId id) {
		this.id = id;
	}

	public String getChTitle() {
		return this.chTitle;
	}

	public void setChTitle(String chTitle) {
		this.chTitle = chTitle;
	}

	public String getChType() {
		return this.chType;
	}

	public void setChType(String chType) {
		this.chType = chType;
	}

	public Boolean getRequired() {
		return this.required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Byte getNumValue() {
		return this.numValue;
	}

	public void setNumValue(Byte numValue) {
		this.numValue = numValue;
	}

}
