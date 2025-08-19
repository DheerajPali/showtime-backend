package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.model.Auditorium;
import dev.dheeraj.showtime.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditoriums")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping("/{id}")
    public ResponseEntity<Auditorium> getAuditoriumById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(auditoriumService.getAuditoriumById(id));
    }

    @GetMapping
    public ResponseEntity<List<Auditorium>> getAllAuditoriums() {
        return ResponseEntity.ok(auditoriumService.getAllAuditoriums());
    }

    @PostMapping
    public ResponseEntity<Auditorium> createAuditorium(@RequestBody Auditorium auditorium) {
        Auditorium savedAuditorium = auditoriumService.saveAuditorium(auditorium);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuditorium);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditorium(@PathVariable int id) {
        auditoriumService.deleteAuditoriumById(id);
        return ResponseEntity.noContent().build();
    }
}
