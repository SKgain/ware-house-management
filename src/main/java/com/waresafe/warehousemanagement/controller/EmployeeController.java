package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Employee;
import com.waresafe.warehousemanagement.requestDTO.EmployeeRequestDTO;
import com.waresafe.warehousemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add-employee")
    public ResponseEntity<String> addEmployee(
            @RequestBody EmployeeRequestDTO employeeDTO
    ){
        employeeService
                .addEmployee(employeeDTO);
        return
                ResponseEntity
                        .ok("Employee added");
    }

//    update employee profile
    @PutMapping("/update-profile/{id}")
    public ResponseEntity<String> updateProfile(
            @PathVariable int id,
            @RequestBody EmployeeRequestDTO employeeDTO
    ){
        employeeService
                .updateProfile(id,employeeDTO);
        return
                ResponseEntity
                        .ok("Employee updated successfully");
    }

//    fetch all employee
    @GetMapping("/get-all-employee")
    public List<Employee> getAllEmployee(){
        return
                employeeService
                        .getAllEmployee();
    }

//    fetch employee by id
    @GetMapping("/get-employee/filter/{id}")
    public Employee getEmployeeById(
            @PathVariable int id
    ){
        return
                employeeService
                        .getEmployeeById(id);
    }

//  delete employee
@DeleteMapping("/delete-employee/{id}")
public ResponseEntity<String> deleteEmployee(
        @PathVariable int id
){
        employeeService
                .deleteEmployee(id);
        return
                ResponseEntity
                        .ok("Employee deleted successfully");
}
}
