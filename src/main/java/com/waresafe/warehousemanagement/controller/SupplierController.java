package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Supplier;

import com.waresafe.warehousemanagement.requestDTO.SupplierRequestDTO;
import com.waresafe.warehousemanagement.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    @PostMapping("/add-supplier")
    public ResponseEntity<String> addSupplier(
            @RequestBody SupplierRequestDTO supplierDTO
    ){
        supplierService
                .addSupplier(supplierDTO);
        return
                ResponseEntity
                        .ok("Supplier added successfully");
    }
    @PutMapping("/update-profile/{id}")
    public ResponseEntity<String> updateProfile(
            @PathVariable int id,
            @RequestBody SupplierRequestDTO supplierDTO
    ){
        supplierService
                .updateProfile(id, supplierDTO);
        return
                ResponseEntity
                        .ok("Profile updated successfully");
    }

    @GetMapping("/get-all-supplier")
    public List<Supplier> getAllSupplier(){
        return
                supplierService
                        .getAllSupplier();
    }
    @DeleteMapping("/delete-supplier/{id}")
    public ResponseEntity<String> deleteSupplier(
            @RequestParam int id
    ){
        supplierService
                .deleteSupplier(id);
        return
                ResponseEntity
                        .ok("Supplier deleted successfully");
    }


}
