package com.waresafe.warehousemanagement.requestDTO;

import com.waresafe.warehousemanagement.entity.Employee;
import com.waresafe.warehousemanagement.entity.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShipmentRequestDTO {
    private LocalDate date;
    private String status;
    private String type;
    private int customerId;
    private int transportVehicleId;
    private int  scheduleId;
    private int  warehouseId;
    private int  employeeId;
}
