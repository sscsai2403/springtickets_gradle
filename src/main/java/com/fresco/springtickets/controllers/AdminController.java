package com.fresco.springtickets.controllers;

import com.fresco.springtickets.models.Admin;
import com.fresco.springtickets.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/new-admin")
    public Admin createAdmin(@RequestParam String name) {
        return adminService.createAdmin(name);
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
}