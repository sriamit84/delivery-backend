package com.fresure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", updatable = false, nullable = false)
	private Integer orderId;

	private Integer quantity;

	private Date orderDate;
	
	private Double price ;

	private boolean subscribedOrder;

	@OneToOne
	private ItemEntity itemEntity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_customer", nullable = false)
	private CustomerEntity customerEntity;

	@OneToOne
	private DeliveryExecutiveEntity deliveryExec;

}
