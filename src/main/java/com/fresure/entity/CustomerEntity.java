package com.fresure.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Set;


@Entity
@Table(name = "CUSTOMER_DETAILS")
@JsonInclude(Include.NON_NULL)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends UserEntity {

	@OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@Nullable
	private Set<OrderEntity> orderEntities;

	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@Nullable
	private Set<SubscriptionEntity> subscriptionEntities;

	@OneToOne
	private WalletEntity wallet ;

	public void addAddress(AddressEntity addressEntity){
		this.getAddressEntities().add(addressEntity);
	}

	public void addOrder(OrderEntity orderEntity){
		this.getOrderEntities().add(orderEntity);
	}

	public void addSubscription(SubscriptionEntity subscriptionEntity){
		this.getSubscriptionEntities().add(subscriptionEntity);
	}

}
