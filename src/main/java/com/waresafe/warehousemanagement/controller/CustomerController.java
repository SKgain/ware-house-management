package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Customer;
import com.waresafe.warehousemanagement.requestDTO.CustomerRequestDTO;
import com.waresafe.warehousemanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity<String> addCustomer(
            @RequestBody CustomerRequestDTO customerDTO
    ){
        customerService.addCustomer(customerDTO);
        return
                ResponseEntity
                        .ok("Customer added successfully");
    }
//update customer profile
    @PutMapping("/update-profile/{id}")
    public ResponseEntity<String> updateProfile(
            @PathVariable int id,
            @RequestBody CustomerRequestDTO customerDTO
    ){
        customerService
                .updateProfile(id,customerDTO);
        return
                ResponseEntity
                        .ok("Profile updated successfully");
    }

//    fetch customer data
    @GetMapping("/get-all-customer")
    public List<Customer> getAllCustomer(){
       return customerService
                .getAllCustomer();
    }

//    fetch customer by id
    @GetMapping("/get-customer/filter/{id}")
    public Customer getCustomerFilter(
            @PathVariable int id
    ){
        return
                customerService
                        .getCustomerFilter(id);
    }

//    delete customer
    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<String> deleteCustomer(
            @PathVariable int id
    ){
        customerService
                .deleteCustomer(id);
        return
                ResponseEntity
                        .ok("Customer deleted successfully");
    }
}
