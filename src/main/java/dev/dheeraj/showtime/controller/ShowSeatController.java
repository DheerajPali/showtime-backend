package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.model.ShowSeat;
import dev.dheeraj.showtime.service.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show-seats")
public class ShowSeatController {

    @Autowired
    private ShowSeatService showSeatService;

    @GetMapping("/{id}")
    public ResponseEntity<ShowSeat> getShowSeatById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(showSeatService.getShowSeatById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowSeat>> getAllShowSeats() {
        return ResponseEntity.ok(showSeatService.getAllShowSeats());
    }

    @PostMapping
    public ResponseEntity<ShowSeat> createShowSeat(@RequestBody ShowSeat showSeat) {
        ShowSeat savedShowSeat = showSeatService.saveShowSeat(showSeat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShowSeat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowSeat(@PathVariable int id) {
        showSeatService.deleteShowSeatById(id);
        return ResponseEntity.noContent().build();
    }
}
