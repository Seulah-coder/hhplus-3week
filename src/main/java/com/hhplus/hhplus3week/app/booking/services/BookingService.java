package com.hhplus.hhplus3week.app.booking.services;

import com.hhplus.hhplus3week.app.booking.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;


}
