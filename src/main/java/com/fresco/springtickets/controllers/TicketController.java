package com.fresco.springtickets.controllers;

import com.fresco.springtickets.models.Ticket;
import com.fresco.springtickets.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/new-ticket")
    public Ticket createTicket(@RequestParam String sender, @RequestParam String content, @RequestParam String email_id) {
        return ticketService.createTicket(sender, content, email_id);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticketsByEmail")
    public List<Ticket> getAllTicketsByEmail(@RequestParam String email_id) {
        return ticketService.getAllTicketsByEmail(email_id);
    }
}