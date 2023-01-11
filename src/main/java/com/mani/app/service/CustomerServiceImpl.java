package com.mani.app.service;

import com.mani.app.dto.CustomerResponse;
import com.mani.app.entity.Customer;
import com.mani.app.exception.CustomerNotFoundException;
import com.mani.app.mapper.CustomerMapper;
import com.mani.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse saveCustomer(CustomerResponse customerResponse) {
        Customer customer = customerMapper.DtoToEntity(customerResponse);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.EntityToDto(savedCustomer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::EntityToDto).collect(Collectors.toList());
    }

    /*common method to fetch the customerId*/
    private Customer fetchCustomerById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer", "id", id));
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = fetchCustomerById(id);
        return customerMapper.EntityToDto(customer);
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerResponse customerResponse) {
        //Customer existingCustomer = customerRepository.findById(id).get();
        Customer existingCustomer = fetchCustomerById(id);
        existingCustomer.setAge(customerResponse.getCustomerAge());
        existingCustomer.setFirstName(customerResponse.getCustomerFirstName());
        existingCustomer.setLastName(customerResponse.getCustomerLastName());
        existingCustomer.setGender(customerResponse.getCustomerGender());
        existingCustomer.setMobileNumber(customerResponse.getCustomerMobileNumber());
        existingCustomer.setEmail(customerResponse.getCustomerEmail());
        existingCustomer.setNationality(customerResponse.getCustomerNationality());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return customerMapper.EntityToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {

        Customer existingCustomer = fetchCustomerById(id);
        customerRepository.deleteById(id);

    }
}
