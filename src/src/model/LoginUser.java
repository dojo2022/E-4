package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_id;	// ログイン時のID

	public LoginUser() {
		this(null);
	}

	public LoginUser(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
