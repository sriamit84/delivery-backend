package com.fresure.model;

import java.util.Date;

public class Item {
	private String itemId;
	private String name;
	private String thumbnail;
// L, ml, g , kg .. change into enum

	private String measurementUnit;
	
	private Double price ;
	
	private Date priceValidityFrom ;
	
	private Date priceValidityTo ;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPriceValidityFrom() {
		return priceValidityFrom;
	}

	public void setPriceValidityFrom(Date priceValidityFrom) {
		this.priceValidityFrom = priceValidityFrom;
	}

	public Date getPriceValidityTo() {
		return priceValidityTo;
	}

	public void setPriceValidityTo(Date priceValidityTo) {
		this.priceValidityTo = priceValidityTo;
	}
	
}
