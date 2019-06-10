package com.qudi.bean;
/**
 * 地址bean
 * @author AlanAtlantis
 *
 */
public class Address {

	private int id;// id
	private String address;// 地址
	private String mobile;// 电话
	private String name;// 姓名
	private String label;// 标签
	private int status;// 状态
	private String detailedAddress;// 详细地址
	private String initializationTime;// 创建时间
	private String updateTime;// 修改时间
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getDetailedAddress() {
		return detailedAddress;
	}



	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
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



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Address [id=" + id + ",address=" + address + ",mobile=" + mobile + ",name=" + name + ",label=" + label
				+ ",status=" + label + ",detailedAddress=" + detailedAddress + ",initializationTime=+"
				+ initializationTime + ",updateTime=" + updateTime + "]";
	}

}
