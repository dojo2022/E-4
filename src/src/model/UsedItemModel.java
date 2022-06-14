package model;

import java.io.Serializable;

public class UsedItemModel implements Serializable {
	private String user_id;
	private String coordinate_id;
	private String item_id;


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
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
}
