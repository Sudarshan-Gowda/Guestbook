package com.guestbook.constants;

public enum RoleType {
	USER("USER", "User"), ADMIN("ADMIN", "Admin");

	private String roleKey;
	private String roleValue;

	RoleType(String roleKey, String roleValue) {
		this.roleKey = roleKey;
		this.roleValue = roleValue;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public String getRoleValue() {
		return roleValue;
	}
}