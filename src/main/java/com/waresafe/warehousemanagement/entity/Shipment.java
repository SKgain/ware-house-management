package com.waresafe.warehousemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    @JsonBackReference
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name="employee_id")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="transport_vehicle_id")
    @JsonBackReference
    private TransportVehicle transportVehicle;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    @JsonBackReference
    private Schedule schedule;

    @OneToMany(mappedBy = "shipment")
    @JsonManagedReference
    private List<ShipmentItem> shipmentItems;

    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Customer customer;

}
