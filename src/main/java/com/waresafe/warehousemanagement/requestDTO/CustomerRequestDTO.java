package com.waresafe.warehousemanagement.requestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequestDTO {
    private String name;
    private String contact;
    private String address;
}
