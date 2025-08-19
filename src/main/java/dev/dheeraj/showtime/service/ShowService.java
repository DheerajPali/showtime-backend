package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.ShowNotFoundException;
import dev.dheeraj.showtime.model.Seat;
import dev.dheeraj.showtime.model.Show;
import dev.dheeraj.showtime.model.ShowSeat;
import dev.dheeraj.showtime.model.constants.ShowSeatStatus;
import dev.dheeraj.showtime.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor // generates constructor for final fields
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatService showSeatService;

    public Show getShowById(int id) {
        return showRepository.findById(id).orElseThrow(
                () -> new ShowNotFoundException("Show not found, please enter a valid show id")
        );
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show saveShow(Show show) {
        //create the showSeats for the show
        List<ShowSeat> showSeats = new ArrayList<>();
        show = showRepository.save(show);

        List<Seat> seats = show.getAuditorium().getSeats();
        for (Seat seat : seats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setPrice(100);
            showSeat.setShow(show);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeat = showSeatService.saveShowSeat(showSeat);
            showSeats.add(showSeat);
        }
        show.setShowSeats(showSeats);
        return show;
    }

    public void deleteShowById(int id) {
        if (!showRepository.existsById(id)) {
            throw new ShowNotFoundException("Show not found with id " + id + ". It may have already been deleted.");
        }
        showRepository.deleteById(id);
    }
}
