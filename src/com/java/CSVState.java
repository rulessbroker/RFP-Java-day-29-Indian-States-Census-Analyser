package com.java;

public class CSVState {
	private String name;
	private String code;

	public CSVState(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CSVStates{" + "name='" + name + '\'' + ", code='" + code + '\'' + '}';
	}
}
