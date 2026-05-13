package com.jayshree.bookmyshow.controller;

import com.jayshree.bookmyshow.dto.BookingDto;
import com.jayshree.bookmyshow.dto.BookingRequestDto;
import com.jayshree.bookmyshow.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;


    //@Valid checks data format & rules, not database truth.
//    @PostMapping
//    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingRequestDto bookingRequest)
//    {
//        return ResponseEntity<>(bookingService.createBooking(bookingRequest),
//        HttpStatus.CREATED);
//    }
}
