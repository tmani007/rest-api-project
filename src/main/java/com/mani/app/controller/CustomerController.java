package com.mani.app.controller;

import com.mani.app.dto.CustomerResponse;
import com.mani.app.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> saveCustomer(@Valid @RequestBody CustomerResponse customerResponse) {
        CustomerResponse response = customerService.saveCustomer(customerResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomersById(@PathVariable Long id) {
        CustomerResponse customerResponse = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id,
                                                           @Valid @RequestBody CustomerResponse customerResponse) {
        CustomerResponse updatedResponse = customerService.updateCustomer(id, customerResponse);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted Successfully");
    }

}
