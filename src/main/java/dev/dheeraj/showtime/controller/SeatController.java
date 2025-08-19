package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.model.Seat;
import dev.dheeraj.showtime.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat savedSeat = seatService.createSeat(seat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSeat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable int id) {
        seatService.deleteSeatById(id);
        return ResponseEntity.noContent().build();
    }
}
