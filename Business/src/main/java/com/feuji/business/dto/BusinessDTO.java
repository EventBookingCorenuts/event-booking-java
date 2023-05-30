package com.feuji.business.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BusinessDTO 
{
	private int businessId;
	
	private String businessName;
	
	private String description;
	
	private int locationId;
	
	private int registerId;
	
	private int imageId;
	
	private int cityId;
	
	private int pincode;
}
