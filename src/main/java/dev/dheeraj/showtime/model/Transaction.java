package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.TransactionStatus;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Transaction extends BaseModel{
    private String transactionMode;
    private LocalDate transactionTime;
    private double amount;
    private String transactionRef;
    private TransactionStatus transactionStatus;
}
