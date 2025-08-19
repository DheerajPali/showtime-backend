package dev.dheeraj.bookmyshow.repository;

import dev.dheeraj.bookmyshow.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
}
