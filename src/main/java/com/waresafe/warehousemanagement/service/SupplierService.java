package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Supplier;
import com.waresafe.warehousemanagement.repository.SupplierRepository;
import com.waresafe.warehousemanagement.requestDTO.SupplierRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public void addSupplier(
            SupplierRequestDTO supplierDTO
    ){
        Supplier supplier = new Supplier();
        supplier
                .setName(supplierDTO.getName());
        supplier
                .setAddress(supplierDTO.getAddress());
        supplier
                .setContact(supplierDTO.getContact());
        supplierRepository
                .save(supplier);
    }
// handel supplier profile update
    public void updateProfile(
            int id,
            SupplierRequestDTO supplierDTO
    ){
        Supplier supplier = supplierRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Supplier not found"));
        supplier
                .setName(supplierDTO.getName());
        supplier
                .setContact(supplierDTO.getContact());
        supplier
                .setAddress(supplierDTO.getAddress());
        supplierRepository
                .save(supplier);

    }

    public List<Supplier> getAllSupplier() {
        return
                supplierRepository
                        .findAll();
    }

    public void deleteSupplier(
            int id
    ) {
        Supplier supplier = supplierRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
        supplierRepository
                .delete(supplier);
    }


}
