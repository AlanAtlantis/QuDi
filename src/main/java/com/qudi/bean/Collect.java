package com.qudi.bean;

import java.util.List;

/**
 * ��Ʒ�ղ�
 * 
 * @author AlanAtlantis
 *
 */
public class Collect {

	private int id;
	private String time;// ���ʱ��
	private int commodityId;// ��Ʒid
	private int userId;// �û�id
	private Commodity commodity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Collect [id=" + id + ",time=" + time + ",commodityId=" + commodityId + ",userId=" + userId
				+ ",commodity=" + commodity + "]";
	}

}
