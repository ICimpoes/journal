package com.icimpoes.journal.util;

public enum Messages {
	SUCCESS("Success");

	private String text;

	private Messages(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
