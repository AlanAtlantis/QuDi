package com.qudi.bean;

/**
 * 购物车
 * 
 * @author AlanAtlantis
 *
 */
public class ShoppingTrolley {

	private int id;// id
	private int commodityId;// 商品id
	private int userId;// 用户id
	private String time;// 添加时间
	private Commodity commodity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ShoppingTrolley [id=" + id + ",commodityId=" + commodityId + ",userId=" + userId + ",time=" + time
				+ ",commodity=" + commodity + "]";
	}

}
