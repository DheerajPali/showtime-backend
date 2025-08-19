package dev.dheeraj.bookmyshow.service;

import dev.dheeraj.bookmyshow.exception.TransactionNotFoundException;
import dev.dheeraj.bookmyshow.model.Transaction;
import dev.dheeraj.bookmyshow.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id).orElseThrow(
                () -> new TransactionNotFoundException("Transaction not found, please provide a valid transaction id")
        );
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransactionById(int id) {
        if (!transactionRepository.existsById(id)) {
            throw new TransactionNotFoundException("Transaction not found with id " + id + ". It may have already been deleted.");
        }
        transactionRepository.deleteById(id);
    }
}
