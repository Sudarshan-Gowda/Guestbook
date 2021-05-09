package com.guestbook.constants;

public enum ActionType {
	UPDATE("UPDATE", "Update"), ADD("ADD", "Add"), VIEW("VIEW", "View");

	private String key;
	private String value;

	ActionType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}