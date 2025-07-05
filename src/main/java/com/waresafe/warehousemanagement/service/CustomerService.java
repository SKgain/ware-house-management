package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Customer;
import com.waresafe.warehousemanagement.repository.CustomerRepository;
import com.waresafe.warehousemanagement.requestDTO.CustomerRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void addCustomer(
            CustomerRequestDTO customerDTo
    ){
        Customer customer = new Customer();
        customer
                .setName(customerDTo.getName());
        customer
                .setContact(customerDTo.getContact());
        customer
                .setAddress(customerDTo.getAddress());
        customerRepository
                .save(customer);
    }
//    handel customer profile update
    public void updateProfile(
            int id,
            CustomerRequestDTO customerDTO
    ){
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not Found"));
        customer
                .setName(customerDTO.getName());
        customer
                .setAddress(customerDTO.getAddress());
        customer
                .setContact(customerDTO.getContact());
        customerRepository
                .save(customer);
    }

// fetch all customer
    public List<Customer> getAllCustomer() {
        return
                customerRepository
                        .findAll();
    }

//fetch customer by id
    public Customer getCustomerFilter(
            int id
    ){
        return customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not Found"));
    }

// delete customer
    public void deleteCustomer(
            int id
    ){
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not Found"));
        customerRepository
                .delete(customer);
    }


}
