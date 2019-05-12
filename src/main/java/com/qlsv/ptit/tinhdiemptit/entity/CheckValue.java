package com.qlsv.ptit.tinhdiemptit.entity;

public enum CheckValue {
	OK("OK"),
	NOT_OK("NOT_OK");
	
	private final String value;

	private CheckValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
