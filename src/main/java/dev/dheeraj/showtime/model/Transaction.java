package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.TransactionStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class Transaction extends BaseModel{
    private String transactionMode;
    private LocalDate transactionTime;
    private double amount;
    private String transactionRef;
    private TransactionStatus transactionStatus;
}
