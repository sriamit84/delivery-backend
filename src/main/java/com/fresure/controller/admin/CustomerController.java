package com.fresure.controller.admin;

import com.fresure.constants.Constants;
import com.fresure.entity.CustomerEntity;
import com.fresure.entity.SubscriptionEntity;
import com.fresure.exceptions.EntityNotFoundException;
import com.fresure.exceptions.FresureException;
import com.fresure.model.Customer;
import com.fresure.model.Subscription;
import com.fresure.payload.response.ErrorMessage;
import com.fresure.payload.response.FresureResponse;
import com.fresure.payload.response.HTTPStatus;
import com.fresure.payload.response.ResponseStatus;
import com.fresure.repo.*;
import com.fresure.service.CustomerService;
import com.fresure.transformer.ObjectTransformationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(path = "/admin/customers")
public class CustomerController {

	@Value("${http_scheme}")
	private String httpScheme;

	@Value("${host_name}")
	private String hostName;

	@Value("${port}")
	private String port;

	@Autowired
	private SubscriptionRepository subscriptionRepo;

	@Autowired
	CustomerService customerService;


	@Autowired
	private MessageSource messageSource;

	@PostMapping(path = "/{username}/subscriptions")
	public @ResponseBody ResponseEntity<FresureResponse> createSubscription( @PathVariable String username,
			@RequestBody Subscription subscription) throws FresureException {
		FresureResponse<Customer> fresureResponse = new FresureResponse<>();
		try {
			CustomerEntity customerEntity = customerService.findCustomerByUserName(username);
			if (customerEntity!=null) {
				SubscriptionEntity subscriptionEntity = ObjectTransformationUtil.transformModelToSubscriptionEntity(subscription);

				customerEntity.addSubscription(subscriptionEntity);

				customerEntity = customerService.updateCustomer(username, customerEntity);
				if (customerEntity != null) {
					Customer resCustomer = ObjectTransformationUtil.transformDAOToCustomerModel(customerEntity);
					return ResponseEntity.created(new URI(messageSource.getMessage(Constants.SUBSCRIPTION_URL, new Object[]{httpScheme,hostName,port},
							Locale.ENGLISH))).body(fresureResponse.setItem(resCustomer).setStatus(ResponseStatus.SUCCESS));
				} else {
					throw new FresureException(messageSource.
							getMessage(Constants.SUBSCRIPTION_NOT_CREATED, new Object[]{subscription}, Locale.ENGLISH));
				}
			}else {
				throw new EntityNotFoundException( messageSource.
						getMessage(Constants.CUSTOMER_NOT_FOUND, new Object[]{username}, Locale.ENGLISH));
			}
		} catch (Exception e) {
			throw new FresureException(messageSource.getMessage(Constants.ERROR, new Object[]{subscription}, Locale.ENGLISH),e);
		}

	}

	@GetMapping(path = "/{username}/subscriptions/{subscriptionId}")
	public @ResponseBody
	ResponseEntity<FresureResponse> getSubscriptionBySubscriptionId(@PathVariable String username,@PathVariable Long subscriptionId) {
		FresureResponse<Subscription> fresureResponse = new FresureResponse<>();
		try {
			CustomerEntity customerEntity= customerService.findCustomerByUserName(username);
			if (customerEntity!=null) {
				SubscriptionEntity subscription = customerEntity.getSubscriptionEntities().stream().filter(subscriptionEntity -> subscriptionEntity.getSubscriptionId().equals(subscriptionEntity)).findFirst().orElse(null);
				if(subscription!=null){
					Subscription resSubs = ObjectTransformationUtil.transformDAOToSubscription(subscription);
					return ResponseEntity.ok().body(fresureResponse.setItem(resSubs).setStatus(ResponseStatus.SUCCESS));
				}else{
					fresureResponse.setStatus(ResponseStatus.FAILED).
							addErrorMessage(new ErrorMessage(HTTPStatus.NOT_FOUND.getCode(), messageSource.
									getMessage(Constants.SUBSCRIPTION_NOT_FOUND, new Object[]{subscriptionId}, Locale.ENGLISH)));
					return new ResponseEntity(fresureResponse, HttpStatus.NOT_FOUND);
				}
			} else {
				fresureResponse.setStatus(ResponseStatus.FAILED).
						addErrorMessage(new ErrorMessage(HTTPStatus.NOT_FOUND.getCode(), messageSource.
								getMessage(Constants.CUSTOMER_NOT_FOUND, new Object[]{username}, Locale.ENGLISH)));
				return new ResponseEntity(fresureResponse, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			fresureResponse.setStatus(ResponseStatus.FAILED).addErrorMessage(new ErrorMessage(HTTPStatus.INTERNAL_SERVER_ERROR.getCode(), messageSource.getMessage(Constants.ERROR, new Object[]{subscriptionId}, Locale.ENGLISH)));
			return new ResponseEntity(fresureResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{username}/subscriptions/{subscriptionId}")
	public @ResponseBody
	ResponseEntity<String> deleteSubscription(@PathVariable Integer subscriptionId) {
		try {
			boolean exists = subscriptionRepo.existsById(subscriptionId);
			if (exists) {
				subscriptionRepo.deleteById(subscriptionId);
			} else {
				throw new Exception("subscription does not exist");
			}

		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity("Subscription Deleted Successfully", HttpStatus.OK);
	}
}

