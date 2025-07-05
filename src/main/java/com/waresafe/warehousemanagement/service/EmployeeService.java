package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Employee;
import com.waresafe.warehousemanagement.repository.EmployeeRepository;
import com.waresafe.warehousemanagement.requestDTO.EmployeeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void addEmployee(
            EmployeeRequestDTO employeeDTO
    ) {
        Employee employee = new Employee();
        employee
                .setName(employeeDTO.getName());
        employee
                .setContact(employeeDTO.getContact());
        employee
                .setRole(employeeDTO.getRole());
        employeeRepository
                .save(employee);
    }
//    employee profile update
    public void updateProfile(
            int id,
            EmployeeRequestDTO employeeDTO
    ){
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));
        employee
                .setName(employeeDTO.getName());
        employee
                .setContact(employeeDTO.getContact());
        employee
                .setRole(employeeDTO.getRole());
        employeeRepository
                .save(employee);
    }
// fetch all employee
    public List<Employee> getAllEmployee() {
        return
                employeeRepository
                        .findAll();
    }
// fetch employee by id
    public Employee getEmployeeById(
            int id
    ) {
        return
                employeeRepository
                        .findById(id)
                        .orElseThrow(()->new RuntimeException("Employee not found"));
    }
// delete employee
    public void deleteEmployee(
            int id
    ) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));
        employeeRepository
                .delete(employee);
    }
}
