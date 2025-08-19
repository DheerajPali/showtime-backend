package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.BookingLimitExceededException;
import dev.dheeraj.showtime.exception.SelectedSeatNotAvailableException;
import dev.dheeraj.showtime.exception.TicketNotFoundException;
import dev.dheeraj.showtime.model.Show;
import dev.dheeraj.showtime.model.ShowSeat;
import dev.dheeraj.showtime.model.Ticket;
import dev.dheeraj.showtime.model.User;
import dev.dheeraj.showtime.model.constants.ShowSeatStatus;
import dev.dheeraj.showtime.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private ShowService showService;


    public Ticket createTicket(int userId, List<Integer> showSeatIds){
        User user = userService.getUserById(userId);
        int totalCost = 0;

        if(showSeatIds.size() > 10){
            throw new BookingLimitExceededException("A user can book maximum 10 tickets at a time");
        }

        List<ShowSeat> showSeats = checkAndUpdateShowSeat(showSeatIds);
        for(ShowSeat showSeat : showSeats){
            totalCost += showSeat.getPrice();
        }

        //TODO: I'LL WRITE LOGIC TO INITIALIZE PAYMENT LATER, THEN POST SUCCESS PAYMENT WE'LL GENERATE TICKET.
        //I'LL UNLOCK SEATS IF PAYMENT IS NOT COMPLETED IN 5 MINUTES.

        Ticket ticket = new Ticket();
        ticket.setTotalCost(totalCost);
        ticket.setUser(user);
        ticket.setShow(showSeats.get(0).getShow());
        ticket.setShowSeats(showSeats);
        ticket = ticketRepository.save(ticket);

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.updateShowSeat(showSeat);
        }

        return ticket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> checkAndUpdateShowSeat(List<Integer> showSeatIds){
        List<ShowSeat> showSeats = new ArrayList<>();
        for(int id : showSeatIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(id);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SelectedSeatNotAvailableException("Please retry booking");
            }
            else {
                showSeats.add(showSeat);
            }
        }

        //now we'll update showseat status , if all seats are available.
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.updateShowSeat(showSeat);
        }
        return showSeats;
    }










//    public Ticket getTicketById(int id) {
//        return ticketRepository.findById(id).orElseThrow(
//                () -> new TicketNotFoundException("Ticket not found, please provide a valid ticket id")
//        );
//    }
//
//    public List<Ticket> getAllTickets() {
//        return ticketRepository.findAll();
//    }
//
//    public Ticket createTicket(Ticket ticket) {
//        return ticketRepository.save(ticket);
//    }
//
//    public void deleteTicketById(int id) {
//        if (!ticketRepository.existsById(id)) {
//            throw new TicketNotFoundException("Ticket not found with id " + id + ". It may have already been deleted.");
//        }
//        ticketRepository.deleteById(id);
//    }
}
