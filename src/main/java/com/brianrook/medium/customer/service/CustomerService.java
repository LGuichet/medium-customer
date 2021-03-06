package com.brianrook.medium.customer.service;

import com.brianrook.medium.customer.dao.CustomerDAO;
import com.brianrook.medium.customer.dao.entity.CustomerEntity;
import com.brianrook.medium.customer.dao.mapper.CustomerEntityMapper;
import com.brianrook.medium.customer.service.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public Customer saveCustomer(Customer customer) {
        return persistCustomer(customer);
    }

    private Customer persistCustomer(Customer customer) {
        CustomerEntity customerEntity = CustomerEntityMapper.INSTANCE.customerToCustomerEntity(customer);
        CustomerEntity storedEntity = customerDAO.save(customerEntity);
        return CustomerEntityMapper.INSTANCE.customerEntityToCustomer(storedEntity);
    }


}