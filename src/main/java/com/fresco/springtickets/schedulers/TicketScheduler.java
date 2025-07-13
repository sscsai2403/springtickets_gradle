package com.fresco.springtickets.schedulers;

import com.fresco.springtickets.models.Admin;
import com.fresco.springtickets.models.Ticket;
import com.fresco.springtickets.repository.AdminRepository;
import com.fresco.springtickets.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class TicketScheduler {

	@Autowired
    private final TicketRepository ticketRepo;
	@Autowired
    private final AdminRepository adminRepo;

    public TicketScheduler(TicketRepository ticketRepo, AdminRepository adminRepo) {
        this.ticketRepo = ticketRepo;
        this.adminRepo = adminRepo;
    }

    @Scheduled(fixedRate = 4000)
    public void assignTicketsToAdmins() {
        List<Ticket> unassigned = ticketRepo.findByStatus("registered");
        List<Admin> admins = adminRepo.findAll();

        if (admins.isEmpty()) return;

        for (Ticket ticket : unassigned) {
            Admin leastBusyAdmin = admins.stream()
                .min(Comparator.comparingInt(Admin::getResolved_count))
                .orElse(null);

            if (leastBusyAdmin != null) {
                ticket.setAdmin_id(leastBusyAdmin.getAdmin_id());
                ticket.setStatus("processing");
                ticketRepo.save(ticket);

                leastBusyAdmin.setResolved_count(leastBusyAdmin.getResolved_count() + 1);
                adminRepo.save(leastBusyAdmin);
            }
        }
    }
}