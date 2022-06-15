package model;

import java.io.Serializable;

public class CoordinateItemModel  implements Serializable{
	private String user_id;
	private String item_id;
	private String item_image;
	private String category;
	private String brand;
	private String size;
	private String flag;
	private String remarks;
	//date入れときました
	private String date;

	public CoordinateItemModel(String user_id, String item_id, String item_image, String category, String brand, String size,
			String flag, String remarks, String date) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
		this.item_image = item_image;
		this.category = category;
		this.brand = brand;
		this.size = size;
		this.flag = flag;
		this.remarks = remarks;
		this.date = date;
	}

	public CoordinateItemModel() {
		super();
		this.user_id = "";
		this.item_id = "";
		this.item_image = "";
		this.category = "";
		this.brand = "";
		this.size = "";
		this.flag = "";
		this.remarks = "";
		this.date = "";
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
