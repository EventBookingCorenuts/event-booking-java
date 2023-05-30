package com.feuji.booking.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feuji.booking.entity.Booking;

@Service
public interface BookingService 
{

	Booking save(Booking booking);

	ResponseEntity<Map<String,List<?>>> getAll();

	void delete(int bookingId);
	
	Booking getBookingById(int bookingId);

}
