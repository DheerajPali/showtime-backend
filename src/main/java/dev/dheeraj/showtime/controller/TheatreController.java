package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.model.Theatre;
import dev.dheeraj.showtime.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheatreController {

    @Autowired
    private TheatreService theaterService;

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheaterById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(theaterService.getTheatreById(id));
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.getAllTheatres());
    }

    @PostMapping
    public ResponseEntity<Theatre> createTheater(@RequestBody Theatre theater) {
        Theatre savedTheater = theaterService.saveTheatre(theater);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTheater);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable int id) {
        theaterService.deleteTheatreById(id);
        return ResponseEntity.noContent().build();
    }
}
