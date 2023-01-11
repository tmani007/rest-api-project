package com.mani.app.service;

import com.mani.app.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse saveCustomer(CustomerResponse customer);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse getCustomerById(Long id);

    CustomerResponse updateCustomer(Long id, CustomerResponse customerResponse);

    void deleteCustomer(Long id);
}
