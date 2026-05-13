package com.jayshree.bookmyshow.service;

import com.jayshree.bookmyshow.dto.BookingDto;
import com.jayshree.bookmyshow.dto.BookingRequestDto;
import com.jayshree.bookmyshow.exception.ResourceNotFoundException;
import com.jayshree.bookmyshow.exception.SeatUnavailableException;
import com.jayshree.bookmyshow.model.*;
import com.jayshree.bookmyshow.repository.BookingRepository;
import com.jayshree.bookmyshow.repository.ShowRepository;
import com.jayshree.bookmyshow.repository.ShowSeatRepository;
import com.jayshree.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDto createBooking(BookingRequestDto bookingRequest)
    {
        // Get User from DB using userId coming from booking request.
        // If user does not exist, throw custom ResourceNotFoundException.
        User  user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

        // Get Show (movie show timing) from DB using showId.
        // If show does not exist, stop booking process.
        Show show = showRepository.findById(bookingRequest.getShowId())
                .orElseThrow(() -> new ResourceNotFoundException("Show Not Found"));


        // Fetch all ShowSeat entities using seatIds sent by frontend.
        // These are the seats user selected for booking.
        List<ShowSeat> selectedSeats = showSeatRepository.findAllById(bookingRequest.getSeatIds());



        //  Validate & Lock Seats
        for (ShowSeat seat : selectedSeats) {

            // Check if seat is NOT available.
            // If status is LOCKED or BOOKED, it means someone else already selected it.
            if (!"AVAILABLE".equals(seat.getStatus())) {

                // If even one seat is unavailable, stop entire booking process.
                // Tell user which seat cannot be booked.
                throw new SeatUnavailableException(
                        "Seat " + seat.getSeat().getSeatNumber() + " is not available"
                );

                seat.setStatus("LOCKED");
            }
        }
        showSeatRepository.saveAll(selectedSeats);

        Double totalAmount = selectedSeats.stream().mapToDouble(ShowSeat::getPrice).sum();

        Payment payment = new Payment();
        payment.setAmount(totalAmount);
        payment.setPaymentTime(LocalDateTime.now());
        payment.setPaymentMethod(bookingRequest.getPaymentMethod());
        payment.setStatus("SUCCESS");
        payment.setTransactionId(UUID.randomUUID().toString());


        // Booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        booking.setTotalAmount(totalAmount);
        booking.setBookingNumber(UUID.randomUUID().toString());
        booking.setPayment(payment);

        Booking saveBooking = bookingRepository.save(booking);

        selectedSeats.forEach(seat ->{
            seat.setStatus("BOOKED");
            seat.setBooking(saveBooking);
        });
    }
}
