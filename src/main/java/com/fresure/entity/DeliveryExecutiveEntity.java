package com.fresure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DELIVERY_EXECUTIVE")
@Setter
@Getter
public class DeliveryExecutiveEntity extends UserEntity {

	private String dateOfJoining;

	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@Nullable
	private Set<DeliveryAssignmentEntity> deliveryAssignmentEntities;



}
