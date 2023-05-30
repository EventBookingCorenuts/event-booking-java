package com.feuji.service.entity;

import java.util.List;

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
public class ServiceBusinessDTO
{
	private int serviceBusinessId;
	
	private int serviceId;
	
	private int businessId;
	
	private double cost;
	
	private List<FacilityDTO> facilities;
	
}
