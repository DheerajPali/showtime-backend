package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.TicketNotFoundException;
import dev.dheeraj.showtime.model.Ticket;
import dev.dheeraj.showtime.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new TicketNotFoundException("Ticket not found, please provide a valid ticket id")
        );
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicketById(int id) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketNotFoundException("Ticket not found with id " + id + ". It may have already been deleted.");
        }
        ticketRepository.deleteById(id);
    }
}
