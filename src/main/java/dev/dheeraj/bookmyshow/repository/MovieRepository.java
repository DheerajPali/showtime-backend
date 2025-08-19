package dev.dheeraj.bookmyshow.repository;

import dev.dheeraj.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
