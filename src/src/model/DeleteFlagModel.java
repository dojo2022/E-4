package model;

import java.io.Serializable;

public class DeleteFlagModel implements Serializable{
	private String user_id;
	private String item_id;
	private String flag;

	public DeleteFlagModel(String user_id, String item_id, String flag) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
		this.flag = flag;
	}

	public DeleteFlagModel() {
		super();
		this.user_id = "";
		this.item_id = "";
		this.flag = "";
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
