package com.qudi.bean;

/**
 * 商品规格bean
 * 
 * @author AlanAtlantis
 *
 */
public class Specifications {

	private int id;// id
	private String color;// 颜色
	private String model;// 型号
	private String picture;// 图片

	
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
