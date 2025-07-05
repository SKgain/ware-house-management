package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.TransportVehicle;
import com.waresafe.warehousemanagement.requestDTO.TransportVehicleRequestDTO;
import com.waresafe.warehousemanagement.service.TransportVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport-vehicle")
@RequiredArgsConstructor
public class TransportVehicleController {
    private final TransportVehicleService transportVehicleService;

    @PostMapping("/add-transport-vehicle")
    public ResponseEntity<String> addTransportVehicle(
            @RequestBody TransportVehicleRequestDTO transportVehicleDTO
    ) {
        transportVehicleService
                .addTransportVehicle(transportVehicleDTO);
        return
                ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Transport Vehicle added successfully");
    }

    @GetMapping("/get-all-transport-vehicle")
    public List<TransportVehicle> getAllTransportVehicle() {
        return
                transportVehicleService
                        .getAllTransportVehicle();

    }
    @GetMapping("/get-transport-vehicle/{id}")
    public TransportVehicle getTransportVehicleById(
            @PathVariable int id
    ){
        return
                transportVehicleService
                        .getTransportVehicleById(id);
    }
    @PutMapping("/update-transport-vehicle/{id}")
    public ResponseEntity<String> updateTransportVehicle(
            @RequestBody TransportVehicleRequestDTO transportVehicleDTO,
            @PathVariable int id
    ){
        transportVehicleService
                .updateTransportVehicle(transportVehicleDTO,id);

        return
                ResponseEntity
                .status(HttpStatus.OK)
                .body("Transport Vehicle updated successfully");
    }
    @DeleteMapping("/delete-transport-vehicle/{id}")
    public ResponseEntity<String> deleteTransportVehicle(
            @PathVariable int id
    ){
        transportVehicleService
                .deleteTransportVehicle(id);
        return
                ResponseEntity
                .status(HttpStatus.OK)
                .body("Transport Vehicle deleted successfully");
    }
}
