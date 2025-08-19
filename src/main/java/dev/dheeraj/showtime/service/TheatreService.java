package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.TheatreNotFoundException;
import dev.dheeraj.showtime.model.Theatre;
import dev.dheeraj.showtime.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre getTheatreById(int id) {
        return theatreRepository.findById(id).orElseThrow(
                () -> new TheatreNotFoundException("Theatre not found, please provide a valid theatre id")
        );
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheatreById(int id) {
        if (!theatreRepository.existsById(id)) {
            throw new TheatreNotFoundException("Theatre not found with id " + id + ". It may have already been deleted.");
        }
        theatreRepository.deleteById(id);
    }
}
