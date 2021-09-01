package com.fresure.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fresure.entity.DeliveryAssignmentEntity;
import com.fresure.repo.DeliveryAssignmentRepository;

@Controller
@RequestMapping(path = "/deliveryexec")
public class DeliveryExecResourceController {

	@Autowired
	private DeliveryAssignmentRepository deliveryAssignmentRepo ;

	@GetMapping(path = "/orders")
	public @ResponseBody ResponseEntity<List<DeliveryAssignmentEntity>> getOrdersToDeliverToday() {
		List<DeliveryAssignmentEntity> deliveryAssignmentEntities = new ArrayList<DeliveryAssignmentEntity>();
		Iterable<DeliveryAssignmentEntity> findAll = deliveryAssignmentRepo.findAll();
		findAll.forEach(deliveryAssignmentEntities::add);
		return new ResponseEntity<List<DeliveryAssignmentEntity>>(deliveryAssignmentEntities, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/updatedelivery")
	@Transactional
	public @ResponseBody ResponseEntity<Integer> updateOrder(@RequestBody DeliveryAssignmentEntity deliveryAssignmentEntity) {
		int updateCount = deliveryAssignmentRepo.updateDeliveryStatus(deliveryAssignmentEntity.getDeliveryStatus(), deliveryAssignmentEntity.getDeliveryDateTime(), deliveryAssignmentEntity.getDeliveryAssignmentId());
		return new ResponseEntity<Integer>(updateCount, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/ping")
	public @ResponseBody ResponseEntity<String> ping(){
		String s = "Hello" ;
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
}