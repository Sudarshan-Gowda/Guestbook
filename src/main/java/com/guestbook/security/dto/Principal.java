package com.guestbook.security.dto;

import java.io.Serializable;
import java.util.List;

public class Principal implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = 213002479470725115L;

	// Attributes
	///////////////
	private String userName;
	private List<String> roles;

	// Constructors
	//////////////////
	public Principal() {
		super();
	}

	/**
	 * @param userName
	 * @param roles
	 */
	public Principal(String userName, List<String> roles) {
		super();
		this.userName = userName;
		this.roles = roles;
	}

	// Properties
	///////////////
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
