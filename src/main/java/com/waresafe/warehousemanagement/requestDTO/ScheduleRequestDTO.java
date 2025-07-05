package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDTO {
    private String timeSlot;
    private LocalDate date;
}
