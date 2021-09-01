package com.fresure.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Data<T> {

	private T item;

	public T getItem() {
		return item;
	}



	public void setItem(T item) {
		this.item = item;
	}



	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ErrorMessage> errorMessages;

	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}



	public Data() {
		this.errorMessages = new ArrayList<ErrorMessage>();
	}

	

	public void addErrorMessage(ErrorMessage errorMessage) {
		this.errorMessages.add(errorMessage);
	}

}
