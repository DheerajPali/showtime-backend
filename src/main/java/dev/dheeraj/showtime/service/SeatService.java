package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.SeatNotFoundException;
import dev.dheeraj.showtime.model.Seat;
import dev.dheeraj.showtime.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public Seat getSeatById(int id) {
        return seatRepository.findById(id).orElseThrow(
                () -> new SeatNotFoundException("Seat not found, please provide a valid seat id")
        );
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeatById(int id) {
        if (!seatRepository.existsById(id)) {
            throw new SeatNotFoundException("Seat not found with id " + id + ". It may have already been deleted.");
        }
        seatRepository.deleteById(id);
    }
}
