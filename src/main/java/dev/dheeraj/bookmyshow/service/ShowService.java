package dev.dheeraj.bookmyshow.service;

import dev.dheeraj.bookmyshow.exception.ShowNotFoundException;
import dev.dheeraj.bookmyshow.model.Show;
import dev.dheeraj.bookmyshow.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // generates constructor for final fields
public class ShowService {

    private final ShowRepository showRepository;

    public Show getShowById(int id) {
        return showRepository.findById(id).orElseThrow(
                () -> new ShowNotFoundException("Show not found, please enter a valid show id")
        );
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show saveShow(Show show) {
        return showRepository.save(show);
    }

    public void deleteShowById(int id) {
        if (!showRepository.existsById(id)) {
            throw new ShowNotFoundException("Show not found with id " + id + ". It may have already been deleted.");
        }
        showRepository.deleteById(id);
    }
}
