package com.fresure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SUBSCRIPTION_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscription_id", updatable = false, nullable = false)
	@JsonIgnore
	private Long subscriptionId ;

	@OneToOne
	private ItemEntity itemEntity;
	
	private Integer quantity ;
	
	//@JsonIgnore
	private Date validFrom ;
	
	//@JsonIgnore
	private Date validUpTo ;
	
	//@JsonIgnore
	private Date creationDate ;
	
	//@JsonIgnore
	private Boolean active ;


	
}
