package com.fresco.springtickets.models;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_id;
    private String sender_name;




    private String emailId;
    private String status = "registered";
    private String content;
    private int admin_id = 0;

    public int getTicket_id() { return ticket_id; }
    public void setTicket_id(int ticket_id) { this.ticket_id = ticket_id; }

    public String getSender_name() { return sender_name; }
    public void setSender_name(String sender_name) { this.sender_name = sender_name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getAdmin_id() { return admin_id; }
    public void setAdmin_id(int admin_id) { this.admin_id = admin_id; }
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}