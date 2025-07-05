package com.waresafe.warehousemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double quantity;

    @ManyToOne
    @JoinColumn(name="item_id")
    @JsonBackReference
    private Item item;

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    @JsonBackReference
    private Warehouse warehouse;
}
