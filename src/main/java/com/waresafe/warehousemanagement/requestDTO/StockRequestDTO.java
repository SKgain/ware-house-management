package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockRequestDTO {
    private double quantity;
    private int itemId;
    private int warehouseId;
}
