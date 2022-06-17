package model;

import java.io.Serializable;

public class CoordinateAndItemModel  implements Serializable{
	private String user_id;
	private String coordinate_id;
	private String season;
	private String purpose;
	private String coordinate_image;
	private String item_id;
	private String item_image;
	private String category;
	private String brand;
	private String size;
	private String flag;
	private String remarks;

	public CoordinateAndItemModel(String user_id, String coordinate_id, String season, String purpose, String coordinate_image, String item_id, String item_image, String category, String brand, String size,
			String flag, String remarks) {
		super();
		this.user_id = user_id;
		this.coordinate_id = coordinate_id;
		this.season = season;
		this.purpose = purpose;
		this.coordinate_image = coordinate_image;
		this.item_id = item_id;
		this.item_image = item_image;
		this.category = category;
		this.brand = brand;
		this.size = size;
		this.flag = flag;
		this.remarks = remarks;
	}

	public CoordinateAndItemModel() {
		super();
		this.user_id = "";
		this.coordinate_id = "";
		this.season = "";
		this.purpose = "";
		this.coordinate_image = "";
		this.item_id = "";
		this.item_image = "";
		this.category = "";
		this.brand = "";
		this.size = "";
		this.flag = "";
		this.remarks = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCoordinate_id() {
		return coordinate_id;
	}

	public void setCoordinate_id(String coordinate_id) {
		this.coordinate_id = coordinate_id;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCoordinate_image() {
		return coordinate_image;
	}

	public void setCoordinate_image(String coordinate_image) {
		this.coordinate_image = coordinate_image;
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


}
