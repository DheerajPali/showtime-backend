package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.TransactionNotFoundException;
import dev.dheeraj.showtime.model.Transaction;
import dev.dheeraj.showtime.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id).orElseThrow(
                () -> new TransactionNotFoundException("Transaction not found, please provide a valid transaction id")
        );
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransactionById(int id) {
        if (!transactionRepository.existsById(id)) {
            throw new TransactionNotFoundException("Transaction not found with id " + id + ". It may have already been deleted.");
        }
        transactionRepository.deleteById(id);
    }
}
