package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.TransportVehicle;
import com.waresafe.warehousemanagement.repository.TransportVehicleRepository;
import com.waresafe.warehousemanagement.requestDTO.TransportVehicleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportVehicleService {
    private final TransportVehicleRepository transportVehicleRepository;

    public void addTransportVehicle(TransportVehicleRequestDTO transportVehicleDTO) {
        TransportVehicle transportVehicle = new TransportVehicle();
        transportVehicle
                .setCapacity(transportVehicleDTO.getCapacity());
        transportVehicle
                .setDriver_name(transportVehicleDTO.getDrivarName());
        transportVehicle
                .setNumber(transportVehicleDTO.getNumber());
        transportVehicleRepository
                .save(transportVehicle);

    }
    public List<TransportVehicle> getAllTransportVehicle() {
        return transportVehicleRepository.findAll();
    }

    public TransportVehicle getTransportVehicleById(
            int id
    ){
        return
                transportVehicleRepository
                        .findById(id)
                        .orElseThrow(()-> new RuntimeException("transportVehicle id not found"));
    }

    public void updateTransportVehicle(
            TransportVehicleRequestDTO transportVehicleDTO,
            int id
    ){
        TransportVehicle transportVehicle = transportVehicleRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("transportVehicle id not found"));
        transportVehicle
                .setCapacity(transportVehicleDTO.getCapacity());
        transportVehicle
                .setDriver_name(transportVehicleDTO.getDrivarName());
        transportVehicle
                .setNumber(transportVehicleDTO.getNumber());
        transportVehicleRepository
                .save(transportVehicle);
    }
    public void deleteTransportVehicle(
            int id
    ){
        TransportVehicle transportVehicle = transportVehicleRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("transportVehicle id not found"));
        transportVehicleRepository
                .delete(transportVehicle);
    }
}
