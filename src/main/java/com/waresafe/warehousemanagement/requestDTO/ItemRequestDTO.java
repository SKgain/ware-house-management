package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemRequestDTO {
    private String name;
    private String description;
    private String sku;
    private double price;
    private int supplierId;
}
