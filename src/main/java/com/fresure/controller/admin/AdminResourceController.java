package com.fresure.controller.admin;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fresure.entity.CustomerEntity;
import com.fresure.entity.DeliveryAssignmentEntity;
import com.fresure.entity.DeliveryExecutiveEntity;
import com.fresure.entity.ItemEntity;
import com.fresure.entity.OrderEntity;
import com.fresure.entity.SubscriptionEntity;
import com.fresure.repo.CustomerRepository;
import com.fresure.repo.DeliveryAssignmentRepository;
import com.fresure.repo.DeliveryExecutiveRepository;
import com.fresure.repo.ItemRepository;
import com.fresure.repo.OrderRepository;
import com.fresure.repo.SubscriptionRepository;

@Controller
@RequestMapping(path = "/admin")
public class AdminResourceController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private DeliveryExecutiveRepository deliveryExecRepo;
	
	@Autowired
	private ItemRepository itemRepo ;

	@Autowired
	private DeliveryAssignmentRepository deliveryAssignmentRepo;

	//@GKC ... Insert tested
	@PutMapping(path = "/customer/profile")
	public @ResponseBody ResponseEntity<CustomerEntity> addCustomer(
			@RequestBody CustomerEntity customerEntity) {
		CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
		return new ResponseEntity<CustomerEntity>(savedCustomerEntity, HttpStatus.OK);
	}


	@PostMapping(path = "/subscriptions")
	public @ResponseBody ResponseEntity<SubscriptionEntity> createSubscription(
			@RequestBody SubscriptionEntity subscriptionEntity) {
		SubscriptionEntity savedSubscriptionEntity = subscriptionRepo.save(subscriptionEntity);
		return new ResponseEntity<SubscriptionEntity>(savedSubscriptionEntity, HttpStatus.OK);
	}

	// @Ganesh : TO-DO : This end-point will be called by chron job running in midnight to create orders from subscription
	@PostMapping(path = "/createOrder")
	public @ResponseBody ResponseEntity<OrderEntity> createOrder(
			@RequestBody OrderEntity orderEntity) {

		OrderEntity savedOrderEntity = orderRepo.save(orderEntity);
		return new ResponseEntity<OrderEntity>(savedOrderEntity, HttpStatus.OK);
	}

	//@GKC ... Insert tested
	@PostMapping(path = "/addDeliveryExec")
	public @ResponseBody ResponseEntity<DeliveryExecutiveEntity> addDeliveryExec(
			@RequestBody DeliveryExecutiveEntity deliveryExec) {
		DeliveryExecutiveEntity savedDeliveryExec = deliveryExecRepo.save(deliveryExec);
		return new ResponseEntity<DeliveryExecutiveEntity>(savedDeliveryExec, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/addItem")
	public @ResponseBody ResponseEntity<ItemEntity> addItem(
			@RequestBody ItemEntity itemEntity) {
		ItemEntity savedItemEntity = itemRepo.save(itemEntity);
		return new ResponseEntity<ItemEntity>(savedItemEntity, HttpStatus.OK);
	}
	

	@PostMapping(path = "/assignDelivery")
	public @ResponseBody ResponseEntity<DeliveryAssignmentEntity> assignDelivery(
			@RequestBody DeliveryAssignmentEntity deliveryAssignmentEntity) {
		DeliveryAssignmentEntity savedDeliveryAssignmentEntity = deliveryAssignmentRepo.save(deliveryAssignmentEntity);
		return new ResponseEntity<DeliveryAssignmentEntity>(savedDeliveryAssignmentEntity, HttpStatus.OK);
	}




	@GetMapping(path = "/ping")
	public @ResponseBody ResponseEntity<SubscriptionEntity> ping(){
		
		/*
		String str = "Hello" ;
		return new ResponseEntity<String>(str,HttpStatus.OK);
		*/
		
		
		/*
		 // POC code to add new customer 
		Customer c = new Customer();
		c.setFirstName("Ganesh");
		c.setLastName("Choudhary");
		//middleName,mobileNumber,addrFirstLine,addrSecondLine,locality,landMark,city,pinCode
		c.setMiddleName("Kumar");
		c.setMobileNumber("+91-9986010296");
		c.setAddrFirstLine("B101");
		c.setAddrSecondLine("Ashish JK");
		c.setLocality("Thubrahalli");
		c.setLandMark("Opp Sonesta");
		c.setCity("BLR");
		c.setPinCode("560066");
		
		
		//return new ResponseEntity<Customer>(c,HttpStatus.OK);
		 
		  // POC code to add customer ends here ************************ 

		// POC code to add new Item
		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.of("+05:30");
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		//s.setValidFrom(date);
		
		LocalDate afterMonth = localDate.plusDays(30);
		Date date1 = Date.from(afterMonth.atStartOfDay(defaultZoneId).toInstant());
		
		//s.setValidUpTo(date1);
		
	//	s.setCretionDate(date);
		
		Item item = new Item();
		item.setMeasurementUnit("L");
		item.setName("Fresh Milk");
		item.setPrice(48.00);
		item.setPriceValidityFrom(date);
		item.setPriceValidityTo(date1);
		return new ResponseEntity<Item>(item,HttpStatus.OK);
		
		// ***************** item POC ends here ***************
	
	*/	
		// ******************** POC code to add new subscription
		SubscriptionEntity s = new SubscriptionEntity();
		
		
		//s.setCustomer(c);
		s.setQuantity(1);

		
		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.of("+05:30");
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		//s.setValidFrom(date);
		
		LocalDate afterMonth = localDate.plusDays(30);
		Date date1 = Date.from(afterMonth.atStartOfDay(defaultZoneId).toInstant());
		
		//s.setValidUpTo(date1);
		
	//	s.setCretionDate(date);
		
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setMeasurementUnit("L");
		itemEntity.setName("Fresh Milk");
		itemEntity.setPrice(48.00);
		itemEntity.setPriceValidityFrom(date);
		itemEntity.setPriceValidityTo(date1);
		
		s.setItemEntity(itemEntity);
		s.setActive(true);
		
		return new ResponseEntity<SubscriptionEntity>(s,HttpStatus.OK);
		
		// POC code to add new subscription ends here *************
		  
		 
		/*
		
		// POC code to add new delivery executive 
		DeliveryExecutive deliveryExec = new DeliveryExecutive();
		deliveryExec.setEmpId(1);
		deliveryExec.setFirstName("Vinod");
		//deliveryExec.set
		
		*/
		
		/*
		// POC code to add new Order 
		Order o = new Order();
		
		
		Customer c = new Customer();
		c.setFirstName("Ganesh");
		c.setLastName("Choudhary");
		//middleName,mobileNumber,addrFirstLine,addrSecondLine,locality,landMark,city,pinCode
		c.setMiddleName("Kumar");
		c.setMobileNumber("+91-9986010296");
		c.setAddrFirstLine("B101");
		c.setAddrSecondLine("Ashish JK");
		c.setLocality("Thubrahalli");
		c.setLandMark("Opp Sonesta");
		c.setCity("BLR");
		c.setPinCode("560066");
		
		
		o.setCustomer(c);
		
		
		DeliveryExecutive deliveryExec = new DeliveryExecutive();
		deliveryExec.setEmpId(1);
		deliveryExec.setFirstName("Vinod");
		//deliveryExec.set
		o.setDeliveryExec(deliveryExec );
		
		// from item id fetch the item first and then set into Order
		Item item = new Item();
		item.setMeasurementUnit("L");
		item.setName("Fresh Milk");
		item.setPrice(48.00);
		//item.setPriceValidityFrom(date);
		//item.setPriceValidityTo(date1);
		
		
		o.setItem(item);
		
		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.of("+05:30");
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		o.setOrderDate(date);
		
		Integer quantity = 2;
		o.setQuantity(quantity);
		
		boolean subscribedOrder= false;
		o.setSubscribedOrder(subscribedOrder);
		
		Double price = item.getPrice()* quantity ;
		o.setPrice(price);
		return new ResponseEntity<Order>(o,HttpStatus.OK);
		
		*/
		
	}
}
