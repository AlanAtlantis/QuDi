package com.qudi.bean;

import java.util.List;

/**
 * 用户bean
 * 
 * @author AlanAtlantis
 *
 */
public class User {

	private Integer id;// 用户id
	private String name;// 真实姓名
	private int sex;// 用户性别（1为男，2为女）
	private String password;// 密码
	private int userType;// 用户类型
	private String mobile;// 电话
	private String userName;// 用户姓名
	private String birthday;// 生日
	private String head;// 头像
	private String initializationTime;// 创建时间
	private String updateTime;// 修改时间
	private String nameFirm;// 企业名称
	private String taxpayerIdentificationNumber;// 纳税人识别号

	private List<Address> address;// 地址集合

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getInitializationTime() {
		return initializationTime;
	}

	public void setInitializationTime(String initializationTime) {
		this.initializationTime = initializationTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getNameFirm() {
		return nameFirm;
	}

	public void setNameFirm(String nameFirm) {
		this.nameFirm = nameFirm;
	}

	public String getTaxpayerIdentificationNumber() {
		return taxpayerIdentificationNumber;
	}

	public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
		this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return "User [id=" + id + ",name=" + name + ",sex=" + sex + ",password=" + password + ",userType=" + userType
				+ ",mobile=" + mobile + ",userName=" + userName + ",birthday=" + birthday + ",head=" + head
				+ ",initializationTime=" + initializationTime + ",updateTime=" + updateTime + ",nameFirm=" + nameFirm
				+ ",taxpayerIdentificationNumber=" + taxpayerIdentificationNumber + ",address=" + address+ "]";
	}
}
