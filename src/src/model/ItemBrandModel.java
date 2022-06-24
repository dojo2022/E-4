package model;

import java.io.Serializable;

public class ItemBrandModel  implements Serializable{
	private String user_id;
	private String brand;

	public ItemBrandModel(String user_id, String brand) {
		super();
		this.user_id = user_id;
		this.brand = brand;
	}

	public ItemBrandModel() {
		super();
		this.user_id = "";
		this.brand = "";
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
