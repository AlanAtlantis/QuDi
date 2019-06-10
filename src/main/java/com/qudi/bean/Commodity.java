package com.qudi.bean;

import java.util.List;

/**
 * 商品bean
 * 
 * @author AlanAtlantis
 *
 */
public class Commodity {

	private int id;// id
	private String name;// 商品名称
	private String describe;// 描述
	private String commodityType;// 商品类型
	private int quantity;// 库存数量
	private String initializationTime;// 创建时间
	private String updateTime;// 修改时间
	private List<Price> price;// 价格
	private List<Specifications> specifications;// 规格

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
