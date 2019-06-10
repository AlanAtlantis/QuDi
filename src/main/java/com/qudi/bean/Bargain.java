package com.qudi.bean;

/**
 * 议价
 * 
 * @author AlanAtlantis
 *
 */
public class Bargain {

	private int id;
	private int userId;// 用户id
	private int commodityId;// 商品id
	private double price;// 价格
	private String time;// 时间
	private double unitPrice;// 单价
	private int quantity;// 数量

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bargain [id=" + id + ",userId=" + userId + ",commodityId=" + commodityId + ",price=" + price + ",time="
				+ time + ",unitPrice=" + unitPrice + ",quantity=" + quantity + "]";
	}

}
