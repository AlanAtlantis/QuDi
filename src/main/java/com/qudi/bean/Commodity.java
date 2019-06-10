package com.qudi.bean;

import java.util.List;

/**
 * ��Ʒbean
 * 
 * @author AlanAtlantis
 *
 */
public class Commodity {

	private int id;// id
	private String name;// ��Ʒ����
	private String describe;// ����
	private String commodityType;// ��Ʒ����
	private int quantity;// �������
	private String initializationTime;// ����ʱ��
	private String updateTime;// �޸�ʱ��
	private List<Price> price;// �۸�
	private List<Specifications> specifications;// ���

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public List<Price> getPrice() {
		return price;
	}

	public void setPrice(List<Price> price) {
		this.price = price;
	}

	public List<Specifications> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<Specifications> specifications) {
		this.specifications = specifications;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Commmodity [id=" + id + ",name=" + name + ",describe=" + describe + ",commodityType=" + commodityType
				+ ",quantity=" + quantity + ",initializationTime=" + initializationTime + ",updateTime=" + updateTime
				+ ",price=" + price + ",specifications=" + specifications + "]";
	}

}
