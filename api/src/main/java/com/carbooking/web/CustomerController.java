package com.carbooking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.model.CustomerDto;
import com.carbooking.repo.Customer;
import com.carbooking.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable String customerId){
        return customerService.getCustomer(customerId);
    }
	
	@PutMapping
    public void updateCustomer(@RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerDto);
    }
}
