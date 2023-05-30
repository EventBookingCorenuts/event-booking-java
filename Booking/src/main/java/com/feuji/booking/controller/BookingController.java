package com.feuji.booking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.booking.entity.Booking;
import com.feuji.booking.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController 
{
	@Autowired
	private BookingService bookingService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Booking save(@RequestBody Booking booking)
	{
		return bookingService.save(booking);
	}
	
	@GetMapping()
	public ResponseEntity<Map<String,List<?>>> getAll()
	{
		return bookingService.getAll();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Booking update(@RequestBody Booking booking)
	{
		return bookingService.save(booking);
	}
	
	@DeleteMapping("{bookingId}")
	public void delete(@PathVariable(value = "bookingId") int bookingId)
	{
		bookingService.delete(bookingId);
	}
	
	@GetMapping("{bookingId}")
	public Booking getByBookingId(@PathVariable(value = "bookingId") int bookingId)
	{
		return bookingService.getBookingById(bookingId);
	}
}
