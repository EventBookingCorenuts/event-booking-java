package com.feuji.service.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDTO 
{
	private int facilityId;
	
	private String FacilityName;
	
	private int serviceBusinessId;
}
