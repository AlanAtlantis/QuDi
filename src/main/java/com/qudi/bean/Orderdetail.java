package com.qudi.bean;

public class Orderdetail {

	private int id;// ��ϸid
	private int orderId;// ����id
	private int commodityId;// ��Ʒid
	private int commodityNum;// ��Ʒ����
	private Commodity comm;// ��Ʒ

	public Commodity getComm() {
		return comm;
	}

	public void setComm(Commodity comm) {
		this.comm = comm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public int getCommodityNum() {
		return commodityNum;
	}

	public void setCommodityNum(int commodityNum) {
		this.commodityNum = commodityNum;
	}

	@Override
	public String toString() {

		return "Orderdetail [id=" + id + ",orderId=" + orderId + ",commodityId=" + commodityId + ",commodityNum="
				+ commodityNum + ",comm=" + comm + "]";
	}

}
