package com.fresure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryExecutive {

	private Integer empId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobileNumber;

	private String addrFirstLine;

	private String addrSecondLine;

	private String locality;

	private String landMark;

	private String city;

	private String pinCode;

	private List<DeliveryAssignment> deliveryAssignments = new ArrayList<DeliveryAssignment>();

	
}
