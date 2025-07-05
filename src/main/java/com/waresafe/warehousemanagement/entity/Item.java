package com.waresafe.warehousemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String sku;
    private String description;
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    @JsonBackReference
    private Supplier supplier;

    @OneToMany(mappedBy = "item")
    @JsonManagedReference
    private List<Stock> stocklist;

    @OneToMany(mappedBy = "item")
    private List<ShipmentItem> shipmentItems;
}
