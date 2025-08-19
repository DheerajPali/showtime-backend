package dev.dheeraj.bookmyshow.repository;

import dev.dheeraj.bookmyshow.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
