package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.model.Show;
import dev.dheeraj.showtime.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show savedShow = showService.saveShow(show);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable int id) {
        showService.deleteShowById(id);
        return ResponseEntity.noContent().build();
    }
}
