package com.qudi.bean;

/**
 * ��Ʒ���bean
 * 
 * @author AlanAtlantis
 *
 */
public class Specifications {

	private int id;// id
	private String color;// ��ɫ
	private String model;// �ͺ�
	private String picture;// ͼƬ

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Specifications [id=" + id + ",color=" + color + ",model=" + model + ",picture=" + picture + "]";
	}

}
