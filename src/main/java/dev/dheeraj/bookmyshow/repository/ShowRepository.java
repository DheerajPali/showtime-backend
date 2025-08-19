package dev.dheeraj.bookmyshow.repository;


import dev.dheeraj.bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
