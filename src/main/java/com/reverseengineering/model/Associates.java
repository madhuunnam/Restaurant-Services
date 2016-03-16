package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Associates generated by hbm2java
 */
public class Associates implements java.io.Serializable {

	private Integer assocId;
	private Date joinDate;
	private Date leaveDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nickName;
	private String telephoneNumber;
	private String otherPhone;
	private String addrStNum;
	private String city;
	private String state;
	private String zip;
	private String emailAddress;
	private String password;
	private String bankName;
	private String bankRouteNum;
	private String bankAccNum;
	private String comType;
	private String preTye;
	private Date chgDate;
	private Integer uplineId;
	private String uplineName;
	private Integer gparId;
	private String gparName;
	private Integer ggparId;
	private String ggparName;
	private String promoCode;
	private String adChannel;

	public Associates() {
	}

	public Associates(Date joinDate, String firstName, String lastName, String telephoneNumber, String addrStNum,
			String city, String state, String zip, String emailAddress, String password) {
		this.joinDate = joinDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.addrStNum = addrStNum;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public Associates(Date joinDate, Date leaveDate, String firstName, String middleName, String lastName,
			String nickName, String telephoneNumber, String otherPhone, String addrStNum, String city, String state,
			String zip, String emailAddress, String password, String bankName, String bankRouteNum, String bankAccNum,
			String comType, String preTye, Date chgDate, Integer uplineId, String uplineName, Integer gparId,
			String gparName, Integer ggparId, String ggparName, String promoCode, String adChannel) {
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.telephoneNumber = telephoneNumber;
		this.otherPhone = otherPhone;
		this.addrStNum = addrStNum;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.emailAddress = emailAddress;
		this.password = password;
		this.bankName = bankName;
		this.bankRouteNum = bankRouteNum;
		this.bankAccNum = bankAccNum;
		this.comType = comType;
		this.preTye = preTye;
		this.chgDate = chgDate;
		this.uplineId = uplineId;
		this.uplineName = uplineName;
		this.gparId = gparId;
		this.gparName = gparName;
		this.ggparId = ggparId;
		this.ggparName = ggparName;
		this.promoCode = promoCode;
		this.adChannel = adChannel;
	}

	public Integer getAssocId() {
		return this.assocId;
	}

	public void setAssocId(Integer assocId) {
		this.assocId = assocId;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getAddrStNum() {
		return this.addrStNum;
	}

	public void setAddrStNum(String addrStNum) {
		this.addrStNum = addrStNum;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankRouteNum() {
		return this.bankRouteNum;
	}

	public void setBankRouteNum(String bankRouteNum) {
		this.bankRouteNum = bankRouteNum;
	}

	public String getBankAccNum() {
		return this.bankAccNum;
	}

	public void setBankAccNum(String bankAccNum) {
		this.bankAccNum = bankAccNum;
	}

	public String getComType() {
		return this.comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public String getPreTye() {
		return this.preTye;
	}

	public void setPreTye(String preTye) {
		this.preTye = preTye;
	}

	public Date getChgDate() {
		return this.chgDate;
	}

	public void setChgDate(Date chgDate) {
		this.chgDate = chgDate;
	}

	public Integer getUplineId() {
		return this.uplineId;
	}

	public void setUplineId(Integer uplineId) {
		this.uplineId = uplineId;
	}

	public String getUplineName() {
		return this.uplineName;
	}

	public void setUplineName(String uplineName) {
		this.uplineName = uplineName;
	}

	public Integer getGparId() {
		return this.gparId;
	}

	public void setGparId(Integer gparId) {
		this.gparId = gparId;
	}

	public String getGparName() {
		return this.gparName;
	}

	public void setGparName(String gparName) {
		this.gparName = gparName;
	}

	public Integer getGgparId() {
		return this.ggparId;
	}

	public void setGgparId(Integer ggparId) {
		this.ggparId = ggparId;
	}

	public String getGgparName() {
		return this.ggparName;
	}

	public void setGgparName(String ggparName) {
		this.ggparName = ggparName;
	}

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getAdChannel() {
		return this.adChannel;
	}

	public void setAdChannel(String adChannel) {
		this.adChannel = adChannel;
	}

}
