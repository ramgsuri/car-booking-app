package com.carbooking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.model.BookingDto;
import com.carbooking.repo.Booking;
import com.carbooking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public void doBooking(@RequestBody BookingDto bookingDto){
        bookingService.confirmBooking(bookingDto);
    }
    
    @GetMapping(value="/customer/{custId}")
    public List<Booking> getCustomerBooking(@PathVariable String custId) {
    	return bookingService.getCustomerBooking(custId);
    }

    @GetMapping(value="/dealer/{dealerId}")
    public List<Booking> getDealerBooking(@PathVariable String dealerId) {
    	return bookingService.getDealerBooking(dealerId);
    }
}


