package com.fresure.service.impl;

import com.fresure.entity.CustomerEntity;
import com.fresure.exceptions.FresureException;
import com.fresure.model.Customer;
import com.fresure.repo.CustomerRepository;
import com.fresure.repo.UserRepository;
import com.fresure.service.CustomerService;
import com.fresure.transformer.ObjectTransformationUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    @Override
    public CustomerEntity findCustomerByUserName(String username) {
        CustomerEntity customerEntity=customerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with customerId: " + username));
        return customerEntity;
    }

    @Override
    public Boolean existCustomerByUserName(String username) {
        return customerRepository.existsByUsername(username);
    }

    @Override
    public Iterable<CustomerEntity> findAllCustomers() throws FresureException {
        Iterable<CustomerEntity> customerList= customerRepository.findAll();

        return  customerList;
    }

    @Override
    public void deleteCustomerByUserName(String username) throws FresureException {
        if(existCustomerByUserName(username)){
            customerRepository.deleteByUsername(username);
        }else{
            throw new FresureException("customer does not exist with userName "+username);
        }
    }

    @Override
    public CustomerEntity updateCustomer(String username, CustomerEntity customer) throws FresureException {
        CustomerEntity customerEntity= new CustomerEntity();
        if(existCustomerByUserName(username)){
            customerEntity=customerRepository.save(customerEntity);
        }else{
            throw new FresureException("customer does not exist with userName "+username);
        }
        return customerEntity;
    }

}
