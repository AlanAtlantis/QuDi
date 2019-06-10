package com.qudi.bean;

/**
 * 商品价格bean
 * 
 * @author AlanAtlantis
 *
 */
public class Price {

	private int id;// id
	private int sectionMin;// 区间最小值
	private int sectionMax;// 区间最大值
	private double price;// 价格
	private String initializationTime;// 创建时间
	private String updateTime;// 修改时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionMin() {
		return sectionMin;
	}

	public void setSectionMin(int sectionMin) {
		this.sectionMin = sectionMin;
	}

	public int getSectionMax() {
		return sectionMax;
	}

	public void setSectionMax(int sectionMax) {
		this.sectionMax = sectionMax;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double privce) {
		this.price = privce;
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
		return "Price [id=" + id + ",sectionMin=" + sectionMin + ",sectionMax=" + sectionMax + ",price=" + price
				+ ",initializationTime=" + initializationTime + ",updateTime=" + updateTime + "]";
	}

}
