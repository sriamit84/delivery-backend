package com.fresure.payload.response;


public class FresureResponse<T> {

	private String status;

	private Data<T> data;

	public FresureResponse() {
		data = new Data<T>();
	}


	public String getStatus() {
		return status;
	}

	public Data<T> getData() {
		return data;
	}

	public FresureResponse setStatus(ResponseStatus status) {
		this.status = status.getCode();
		return this;
	}

	public FresureResponse setItem(T values) {
		this.data.setItem(values);
		return this;
	}

	public FresureResponse addErrorMessage(ErrorMessage errorMessage) {
		this.data.addErrorMessage(errorMessage);
		return this;
	}

}
