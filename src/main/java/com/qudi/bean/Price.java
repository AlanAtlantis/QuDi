package com.qudi.bean;

/**
 * ��Ʒ�۸�bean
 * 
 * @author AlanAtlantis
 *
 */
public class Price {

	private int id;// id
	private int sectionMin;// ������Сֵ
	private int sectionMax;// �������ֵ
	private double price;// �۸�
	private String initializationTime;// ����ʱ��
	private String updateTime;// �޸�ʱ��

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
