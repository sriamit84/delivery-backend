package com.fresure.payload.response;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseStatus {

	FAILED("failed"), SUCCESS("success");

	private final String code;

	@JsonValue
	public String getCode() {
		return code;
	}

	ResponseStatus(String code) {

		this.code = code;
	}

}
