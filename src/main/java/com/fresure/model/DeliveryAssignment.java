package com.fresure.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class DeliveryAssignment {

	private Integer deliveryAssignmentId;
	
	private String deliveryStatus;
	private Date deliveryDateTime;

	private Order order ;
	
	private Item item ;

	
	
	
}
