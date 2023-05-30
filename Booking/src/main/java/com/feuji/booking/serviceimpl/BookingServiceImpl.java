package com.feuji.booking.serviceimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.booking.dto.FacilityDTO;
import com.feuji.booking.dto.RegistrationDTO;
import com.feuji.booking.dto.ServiceDTO;
import com.feuji.booking.entity.Booking;
import com.feuji.booking.repository.BookingRepository;
import com.feuji.booking.service.BookingService;
import com.feuji.booking.utils.BookingUtil;

@Service
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Booking save(Booking booking) 
	{
		return bookingRepository.save(booking);
	}
	
	@Autowired
	private BookingUtil bookingUtil;

	@Override
	public ResponseEntity<Map<String,List<?>>> getAll() 
	{
		List<Booking> bookings = bookingRepository.findAll();
		RestTemplate resttemplate=new RestTemplate();
		
		ResponseEntity<FacilityDTO[]> facilityResponse=resttemplate.getForEntity("http://"+bookingUtil.getUrl()+":9063/api/service/facilities", FacilityDTO[].class);
		FacilityDTO[] facilityArray=facilityResponse.getBody();
		List<FacilityDTO> facilities=Arrays.asList(facilityArray);
		
		ResponseEntity<ServiceDTO[]> serviceResponse=resttemplate.getForEntity("http://"+bookingUtil.getUrl()+":9063/api/service/getservices",ServiceDTO[].class);
		ServiceDTO[] serviceArray=serviceResponse.getBody();
		List<ServiceDTO> services=Arrays.asList(serviceArray);
		
		ResponseEntity<RegistrationDTO[]> registrationResponse=resttemplate.getForEntity("http://"+bookingUtil.getUrl()+":9061/api/registration", RegistrationDTO[].class);
		RegistrationDTO[] registrationArray=registrationResponse.getBody();
		List<RegistrationDTO> registrations=Arrays.asList(registrationArray);
		
		Map<String,List<?>> response=new HashMap<>();
		response.put("facilities", facilities);
		response.put("services", services);
		response.put("registrations", registrations);
		response.put("bookings", bookings);
		return ResponseEntity.ok(response);
	}

	@Override
	public void delete(int bookingId)
	{
		bookingRepository.deleteById(bookingId);
	}

	@Override
	public Booking getBookingById(int bookingId)
	{
		return bookingRepository.findById(bookingId).get();
	}

}
