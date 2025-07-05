package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.*;
import com.waresafe.warehousemanagement.repository.*;
import com.waresafe.warehousemanagement.requestDTO.ShipmentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final EmployeeRepository employeeRepository;
    private final WarehouseRepository warehouseRepository;
    private final ScheduleRepository scheduleRepository;
    private final CustomerRepository customerRepository;
    private final TransportVehicleRepository transportVehicleRepository;

    public void addShipment(
            ShipmentRequestDTO shipmentDTO
    ){
        Shipment shipment = new Shipment();

       Warehouse warehouse = warehouseRepository
               .findById(shipmentDTO.getWarehouseId())
               .orElseThrow(()-> new RuntimeException("Warehouse not found"));
       Schedule schedule = scheduleRepository
               .findById(shipmentDTO.getScheduleId())
               .orElseThrow(()-> new RuntimeException("Schedule not found"));
       Employee employee = employeeRepository
               .findById(shipmentDTO.getEmployeeId())
               .orElseThrow(()-> new RuntimeException("Employee not found"));
       TransportVehicle transportVehicle = transportVehicleRepository
               .findById(shipmentDTO.getTransportVehicleId())
               .orElseThrow(()-> new RuntimeException("TransportVehicle not found"));
       Customer customer = customerRepository
               .findById(shipmentDTO.getCustomerId())
               .orElseThrow(()-> new RuntimeException("Customer not found"));

        shipment
                .setType(shipmentDTO.getType());
        shipment
                .setDate(shipmentDTO.getDate());
        shipment
                .setStatus(shipmentDTO.getStatus());
        shipment
                .setWarehouse(warehouse);
        shipment
                .setEmployee(employee);
        shipment
                .setTransportVehicle(transportVehicle);
        shipment
                .setCustomer(customer);
        shipment
                .setSchedule(schedule);
        shipmentRepository.save(shipment);

    }

    public List<Shipment> getAllShipment() {

        return
                shipmentRepository
                        .findAll();
    }

    public Shipment getShipmentById(
            int id
    ){
        return
                shipmentRepository
                        .findById(id)
                        .orElseThrow(()-> new RuntimeException("Shipment not found"));
    }

    public void updateShipment(
            ShipmentRequestDTO shipmentDTO,
            int id
    ){
        Shipment shipment = shipmentRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Shipment not found"));
        shipment
                .setStatus(shipmentDTO.getStatus());
        shipment
                .setDate(shipmentDTO.getDate());
        shipmentRepository
                .save(shipment);
    }

    public void deleteShipment(
            int id
    ) {
        Shipment shipment = shipmentRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Shipment not found"));
        shipmentRepository
                .delete(shipment);
    }
}
