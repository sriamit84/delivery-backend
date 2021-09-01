package com.fresure.transformer;

import com.fresure.entity.*;
import com.fresure.model.*;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


public final class ObjectTransformationUtil {

    static{
//        ConvertUtils.register(new Converter() {
//            @Override
//            public Object convert(Class aClass, Object o) {
//                return ValidationUtil.PARSE_DATE_STRING.apply((String)o);
//            }
//        }, Date.class);
    }

    private ObjectTransformationUtil() {
    }

    public static Customer transformDAOToCustomerModel(CustomerEntity customerEntity) throws InvocationTargetException, IllegalAccessException {

        Customer customerModel = new Customer();
        BeanUtils.copyProperties(customerModel, customerEntity);
        //customerModel.setDateOfBirth(ValidationUtil.CONVERT_DATE_STRING.apply(employeesEntity.getDateOfBirth()));
        if(customerEntity.getAddressEntities()!=null) {
            customerEntity.getAddressEntities().forEach(addressEntity -> {
                try {
                    customerModel.addAddress(transformDAOToAddress(addressEntity));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        if(customerEntity.getOrderEntities()!=null) {
            customerEntity.getOrderEntities().forEach(order -> {
                try {
                    customerModel.addOrder(transformDAOToOrder(order));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        if(customerEntity.getSubscriptionEntities()!=null) {
            customerEntity.getSubscriptionEntities().forEach(subscription -> {
                try {
                    customerModel.addSubscription(transformDAOToSubscription(subscription));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        if(customerEntity.getWallet()!=null) {
            customerModel.setWallet(transformDAOToWallet(customerEntity.getWallet()));
        }

        return customerModel;
    }

    public static com.fresure.model.Address transformDAOToAddress(AddressEntity addressEntity) throws InvocationTargetException, IllegalAccessException {
        com.fresure.model.Address address = new com.fresure.model.Address();
        BeanUtils.copyProperties(address,addressEntity);
        return address;
    }

    public static Order transformDAOToOrder(OrderEntity orderEntity) throws InvocationTargetException, IllegalAccessException {
        Order order = new Order();
        BeanUtils.copyProperties(order,orderEntity);
        return order;
    }

    public static Wallet transformDAOToWallet(WalletEntity walletEntity) throws InvocationTargetException, IllegalAccessException {
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(wallet,walletEntity);
        return wallet;
    }

    public static com.fresure.model.Subscription transformDAOToSubscription(SubscriptionEntity subscriptionEntity) throws InvocationTargetException, IllegalAccessException {

        com.fresure.model.Subscription subscriptionModel = new com.fresure.model.Subscription();
        BeanUtils.copyProperties(subscriptionModel, subscriptionEntity);
        return subscriptionModel;
    }



    public static CustomerEntity transformModelToCustomerEntity(Customer customerModel) throws InvocationTargetException, IllegalAccessException {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerEntity,customerModel);
        if(customerModel.getAddresses()!=null) {
            customerModel.getAddresses().forEach(address -> {
                try {
                    customerEntity.addAddress(transformModelToAddressEntity(address));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        if(customerModel.getOrders()!=null) {
            customerModel.getOrders().forEach(order -> {
                try {
                    customerEntity.addOrder(transformModelToOrderEntity(order));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        if(customerModel.getSubscriptions()!=null) {
            customerModel.getSubscriptions().forEach(subscription -> {
                try {
                    customerEntity.addSubscription(transformModelToSubscriptionEntity(subscription));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        if(customerModel.getWallet()!=null) {
            customerEntity.setWallet(transformModelToWalletEntity(customerModel.getWallet()));
        }

        return customerEntity;
    }
    public static AddressEntity transformModelToAddressEntity(Address address) throws InvocationTargetException, IllegalAccessException {

        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(addressEntity,address);
        return addressEntity;
    }

    public static OrderEntity transformModelToOrderEntity(Order order) throws InvocationTargetException, IllegalAccessException {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderEntity,order);
        return orderEntity;
    }

    public static SubscriptionEntity transformModelToSubscriptionEntity(Subscription subscription) throws InvocationTargetException, IllegalAccessException {
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        BeanUtils.copyProperties(subscriptionEntity,subscription);
        return subscriptionEntity;
    }

    public static WalletEntity transformModelToWalletEntity(Wallet wallet) throws InvocationTargetException, IllegalAccessException {
        WalletEntity walletEntity = new WalletEntity();
        BeanUtils.copyProperties(walletEntity,wallet);
        return walletEntity;
    }
}
