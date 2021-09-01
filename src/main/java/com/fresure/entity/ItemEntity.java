package com.fresure.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_DETAILS")
@Setter
@Getter
@NoArgsConstructor
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id", updatable = false, nullable = false)
	private Integer itemId;
	private String name;
	private String thumbnail;

	private String measurementUnit;
	
	private Double price ;
	
	private Date priceValidityFrom ;
	
	private Date priceValidityTo ;


	
}
