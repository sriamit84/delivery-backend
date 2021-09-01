package com.fresure.payload.response;

public enum HTTPStatus {

	NOT_FOUND("404"), BAD_REQUEST("400"), UNPROCESSABLE_ENTITY("402"), CREATED("201"), OK("200"), UPDATED("204"),
	INTERNAL_SERVER_ERROR("500");

	private final String code;

	public String getCode() {
		return code;
	}

	HTTPStatus(String code) {

		this.code = code;
	}

}
