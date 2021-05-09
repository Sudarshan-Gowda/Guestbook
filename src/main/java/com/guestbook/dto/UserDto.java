package com.guestbook.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = -7261670875826643967L;

	// Attributes
	///////////////////
	private String userName;
	private String password;

	// Properties
	////////////////
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
