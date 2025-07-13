package com.fresco.springtickets.service;

import com.fresco.springtickets.models.Ticket;
import com.fresco.springtickets.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
	@Autowired
    private final TicketRepository ticketRepo;

    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public Ticket createTicket(String sender, String content, String email) {
        Ticket ticket = new Ticket();
        ticket.setSender_name(sender);
        ticket.setEmailId(email);
        ticket.setContent(content);
        return ticketRepo.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public List<Ticket> getRegisteredTickets() {
        return ticketRepo.findByStatus("registered");
    }

    public List<Ticket> getAllTicketsByEmail(String emailId){
        return ticketRepo.findByEmailId(emailId);
    }
}