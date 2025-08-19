package dev.dheeraj.bookmyshow.service;

import dev.dheeraj.bookmyshow.exception.ShowSeatNotFoundException;
import dev.dheeraj.bookmyshow.model.ShowSeat;
import dev.dheeraj.bookmyshow.repository.ShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowSeatService {
    private final ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeatById(int id) {
        return showSeatRepository.findById(id).orElseThrow(
                () -> new ShowSeatNotFoundException("ShowSeat not found, please provide a valid show seat id")
        );
    }

    public List<ShowSeat> getAllShowSeats() {
        return showSeatRepository.findAll();
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    public void deleteShowSeatById(int id) {
        if (!showSeatRepository.existsById(id)) {
            throw new ShowSeatNotFoundException("ShowSeat not found with id " + id + ". It may have already been deleted.");
        }
        showSeatRepository.deleteById(id);
    }
}
