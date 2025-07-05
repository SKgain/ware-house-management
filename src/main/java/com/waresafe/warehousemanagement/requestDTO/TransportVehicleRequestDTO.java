package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransportVehicleRequestDTO {
    private double capacity;
    private String drivarName;
    private String number;
}
