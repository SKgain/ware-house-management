package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WarehouseRequestDTO {
    private int capacity;
    private String location;
    private String name;
}
