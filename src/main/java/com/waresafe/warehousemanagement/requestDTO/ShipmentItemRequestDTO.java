package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShipmentItemRequestDTO {
    private int quantity;
    private int shipmentId;
    private int itemId;
}
