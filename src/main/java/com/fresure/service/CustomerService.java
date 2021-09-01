package com.fresure.service;

import com.fresure.entity.CustomerEntity;
import com.fresure.exceptions.FresureException;
public interface CustomerService {

    public CustomerEntity findCustomerByUserName(String username);

    public Boolean existCustomerByUserName(String username);

    public Iterable<CustomerEntity> findAllCustomers() throws FresureException;

    public void deleteCustomerByUserName(String username) throws FresureException;

    public CustomerEntity updateCustomer(String username, CustomerEntity customer) throws FresureException;

}
