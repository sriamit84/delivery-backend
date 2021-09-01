package com.fresure.model;

import com.fresure.entity.AddressEntity;
import com.fresure.entity.OrderEntity;
import com.fresure.entity.SubscriptionEntity;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Customer extends  User{

	
	private List<Order> orders = new ArrayList<Order>();
	
	private List<Subscription> Subscriptions = new ArrayList<Subscription>();
	
	private Wallet wallet ;

	public void addOrder(Order order){
		this.getOrders().add(order);
	}

	public void addSubscription(Subscription subscription){
		this.getSubscriptions().add(subscription);
	}

	public void addAddress(Address address){
		this.getAddresses().add(address);
	}




	
}
