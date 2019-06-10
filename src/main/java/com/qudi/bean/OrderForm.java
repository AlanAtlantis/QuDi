package com.qudi.bean;

import java.util.List;

/**
 * ����bean
 * 
 * @author AlanAtlantis
 *
 */
public class OrderForm {

	private int id;// id
	private String number;// �������
	private String orderTime;// �µ�ʱ��
	private String modePayment;// ֧����ʽ
	private String shippingMethod;// ���ͷ�ʽ
	private String invoiceType;// ��Ʊ����
	private double freight;// �˷�
	private double price;// ���
	private String status;// ״̬
	private int quantityCommod;// ����
	private String initializationTime;// ��������ʱ��
	private String updateTime;// �����޸�ʱ��
	private List<Orderdetail> detail;

	public List<Orderdetail> getDetail() {
		return detail;
	}

	public void setDetail(List<Orderdetail> detail) {
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getModePayment() {
		return modePayment;
	}

	public void setModePayment(String modePayment) {
		this.modePayment = modePayment;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantityCommod() {
		return quantityCommod;
	}

	public void setQuantityCommod(int quantityCommod) {
		this.quantityCommod = quantityCommod;
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
		return "OrderForm [id=" + id + ",number=" + number + ",orderTime=" + orderTime + ",modePayment=" + modePayment
				+ ",shippingMethod=" + shippingMethod + ",invoiceType=" + invoiceType + ",freight=" + freight
				+ ",price=" + price + ",status=" + status + ",quantityCommod=" + quantityCommod + ",initializationTime="
				+ initializationTime + ",updateTime=" + updateTime + ",detail=" + detail + "]";
	}

}
