package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Admin;
import com.waresafe.warehousemanagement.repository.AdminRepository;
import com.waresafe.warehousemanagement.requestDTO.AdminRequestDTO;
import com.waresafe.warehousemanagement.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

@PostMapping("/add-admin")
public ResponseEntity<String>  addAdmin(
        @RequestBody AdminRequestDTO adminDTO
){
    adminService
            .addAdmin(adminDTO);
    return
            ResponseEntity
                    .ok("Admin successfully added");
}
//    update admin info
@PutMapping("/update-admin-profile/{id}")
public ResponseEntity<String> updateAdminProfile(
        @PathVariable int id,
        @RequestBody AdminRequestDTO adminDTO
){
    adminService
            .updateAdminProfile(id,adminDTO);
        return
                ResponseEntity
                        .ok("Profile updated successfully");

    }

}
