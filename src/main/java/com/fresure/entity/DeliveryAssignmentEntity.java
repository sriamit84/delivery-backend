package com.fresure.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "DELIVERY_ASSIGNMENT_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class DeliveryAssignmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer deliveryAssignmentId;


	private String deliveryStatus;

	@NonNull
	private Date deliveryDateTime;

	@NonNull
	private Integer deliveryQuantity;

	private String comments;

	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@NonNull
	private Set<AddressEntity> addressEntities;

	@ManyToOne
	@JoinColumn(name = "fk_deliveryExec")
	private DeliveryExecutiveEntity deliveryExec;



}
