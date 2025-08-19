package dev.dheeraj.bookmyshow.repository;

import dev.dheeraj.bookmyshow.model.Ticket;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
