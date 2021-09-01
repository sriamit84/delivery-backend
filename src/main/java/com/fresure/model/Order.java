package com.fresure.model;

import java.util.Date;

public class Order {

	private Integer orderId;

	private Integer quantity;

	private Date orderDate;
	
	private Double price ;

	private boolean subscribedOrder;

	private Item item;

	private Customer customer;

	private DeliveryExecutive deliveryExec;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isSubscribedOrder() {
		return subscribedOrder;
	}

	public void setSubscribedOrder(boolean subscribedOrder) {
		this.subscribedOrder = subscribedOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public DeliveryExecutive getDeliveryExec() {
		return deliveryExec;
	}

	public void setDeliveryExec(DeliveryExecutive deliveryExec) {
		this.deliveryExec = deliveryExec;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
