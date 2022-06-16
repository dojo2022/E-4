package model;

import java.io.Serializable;

public class CoordinateModel  implements Serializable{
	private String user_id;
	private String coordinate_id;
	private String season;
	private String purpose;
	private String coordinate_image;
	private String date;
	private String remark;


	public CoordinateModel(String user_id, String coordinate_id, String season, String purpose, String coordinate_image, String date, String remark) {
		this.user_id = user_id;
		this.coordinate_id = coordinate_id;
		this.season = season;
		this.purpose = purpose;
		this.coordinate_image = coordinate_image;
		this.date = date;
		this.remark =remark;
	}

	public CoordinateModel() {
		this.user_id = "";
		this.coordinate_id = "";
		this.season = "";
		this.purpose = "";
		this.coordinate_image = "";
		this.date ="";
		this.remark="";
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
