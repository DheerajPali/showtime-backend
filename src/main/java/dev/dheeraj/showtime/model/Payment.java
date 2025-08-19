package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.PaymentStatus;
import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Entity
public class Payment extends BaseModel{
    private LocalDate paymentTime;
    @OneToOne
//    @JoinColumn(name="payment_id")
    private Ticket ticket;
    @OneToMany
    @JoinColumn(name="payment_id")
    private List<Transaction> transactions;
//    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private double totalAmount;

}
