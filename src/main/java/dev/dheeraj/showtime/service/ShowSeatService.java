package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.ShowSeatNotFoundException;
import dev.dheeraj.showtime.model.ShowSeat;
import dev.dheeraj.showtime.repository.ShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeatById(int id) {
        return showSeatRepository.findById(id).orElseThrow(
                () -> new ShowSeatNotFoundException("ShowSeat not found, please provide a valid show seat id")
        );
    }

    public List<ShowSeat> getAllShowSeats() {
        return showSeatRepository.findAll();
    }

    public ShowSeat createShowSeat(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    public void deleteShowSeatById(int id) {
        if (!showSeatRepository.existsById(id)) {
            throw new ShowSeatNotFoundException("ShowSeat not found with id " + id + ". It may have already been deleted.");
        }
        showSeatRepository.deleteById(id);
    }

    public ShowSeat updateShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);
    }
}
