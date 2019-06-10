package com.qudi.bean;

import java.util.List;

/**
 * �û�bean
 * 
 * @author AlanAtlantis
 *
 */
public class User {

	private Integer id;// �û�id
	private String name;// ��ʵ����
	private int sex;// �û��Ա�1Ϊ�У�2ΪŮ��
	private String password;// ����
	private int userType;// �û�����
	private String mobile;// �绰
	private String userName;// �û�����
	private String birthday;// ����
	private String head;// ͷ��
	private String initializationTime;// ����ʱ��
	private String updateTime;// �޸�ʱ��
	private String nameFirm;// ��ҵ����
	private String taxpayerIdentificationNumber;// ��˰��ʶ���

	private List<Address> address;// ��ַ����

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
