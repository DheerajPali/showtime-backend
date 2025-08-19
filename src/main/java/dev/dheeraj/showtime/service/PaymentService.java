package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.PaymentNotFoundException;
import dev.dheeraj.showtime.model.Payment;
import dev.dheeraj.showtime.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new PaymentNotFoundException("Payment not found, please provide a valid payment id")
        );
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePaymentById(int id) {
        if (!paymentRepository.existsById(id)) {
            throw new PaymentNotFoundException("Payment not found with id " + id + ". It may have already been deleted.");
        }
        paymentRepository.deleteById(id);
    }
}
