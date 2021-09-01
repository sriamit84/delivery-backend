package com.fresure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
	
	private Long subscriptionId ;

	private Item item ;
	
	private Integer quantity ;
	
	private Date validFrom ;
	
	private Date validUpTo ;
	
	private Date creationDate ;
	
	private Boolean active ;

	
}
