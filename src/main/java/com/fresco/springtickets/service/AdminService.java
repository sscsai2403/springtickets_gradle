package com.fresco.springtickets.service;

import com.fresco.springtickets.models.Admin;
import com.fresco.springtickets.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
	@Autowired
    private final AdminRepository adminRepo;

    public AdminService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin createAdmin(String name) {
        Admin admin = new Admin();
        admin.setAdmin_name(name);
        return adminRepo.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }
}