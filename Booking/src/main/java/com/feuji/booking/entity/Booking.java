package com.feuji.booking.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Booking 
{
	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(name = "register_id")
	private int registerId;
	
	@Column(name = "service_business_id")
	private int serviceBusinessId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "event_date")
	private Date eventDate;

	@Column(name="venue")
	private String venue;
	
	@Column(name="contact_number")
	private long contactNo;

	@Column(name = "status")
	private String status;
	
	@Column(name="reason")
	private String reason;
}
