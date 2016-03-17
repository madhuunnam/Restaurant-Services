package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Admins generated by hbm2java
 */
public class Admins implements java.io.Serializable {

	private Integer adminId;
	private Date insertDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private String telephoneNumber;
	private String otherPhone;
	private String mailAddr;
	private String emailAddress;
	private String password;
	private byte question;
	private String answer;

	public Admins() {
	}

	public Admins(Date insertDate, String firstName, String lastName, String telephoneNumber, String mailAddr,
			String emailAddress, String password, byte question, String answer) {
		this.insertDate = insertDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.mailAddr = mailAddr;
		this.emailAddress = emailAddress;
		this.password = password;
		this.question = question;
		this.answer = answer;
	}

	public Admins(Date insertDate, String firstName, String middleName, String lastName, String telephoneNumber,
			String otherPhone, String mailAddr, String emailAddress, String password, byte question, String answer) {
		this.insertDate = insertDate;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.otherPhone = otherPhone;
		this.mailAddr = mailAddr;
		this.emailAddress = emailAddress;
		this.password = password;
		this.question = question;
		this.answer = answer;
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getOtherPhone() {
		return this.otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getMailAddr() {
		return this.mailAddr;
	}

	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getQuestion() {
		return this.question;
	}

	public void setQuestion(byte question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}