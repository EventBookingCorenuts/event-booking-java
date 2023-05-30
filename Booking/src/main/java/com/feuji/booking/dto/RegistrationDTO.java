package com.feuji.booking.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO 
{
	private int registerId;
	
	private String email;
	
	private String password;
	
	private String status;
	
	private int roleId;
	
	private double contact;
	
	private String active;
}
