package com.qudi.bean;

/**
 * ���ﳵ
 * 
 * @author AlanAtlantis
 *
 */
public class ShoppingTrolley {

	private int id;// id
	private int commodityId;// ��Ʒid
	private int userId;// �û�id
	private String time;// ���ʱ��
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
