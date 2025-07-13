package com.fresco.springtickets.models;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;
    private String admin_name;
    private int resolved_count = 0;

    public int getAdmin_id() { return admin_id; }
    public void setAdmin_id(int admin_id) { this.admin_id = admin_id; }

    public String getAdmin_name() { return admin_name; }
    public void setAdmin_name(String admin_name) { this.admin_name = admin_name; }

    public int getResolved_count() { return resolved_count; }
    public void setResolved_count(int resolved_count) { this.resolved_count = resolved_count; }
}