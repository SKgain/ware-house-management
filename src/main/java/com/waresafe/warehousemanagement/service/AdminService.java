package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Admin;
import com.waresafe.warehousemanagement.repository.AdminRepository;
import com.waresafe.warehousemanagement.requestDTO.AdminRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public void addAdmin(
            AdminRequestDTO adminDTO
    ){
        Admin admin = new Admin();
        admin
                .setName(adminDTO.getName());
        admin
                .setContact(adminDTO.getContact());
        adminRepository
                .save(admin);
    }
//    Handel admin profile update
    public void updateAdminProfile(
            int id,
            AdminRequestDTO adminDTO
    ){
        Admin admin =  adminRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Admin Not Found"));
        admin
                .setName(adminDTO.getName());
        admin
                .setContact(adminDTO.getContact());

        adminRepository
                .save(admin);
    }

}
