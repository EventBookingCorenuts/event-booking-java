package com.feuji.service.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feuji.service.entity.FacilityDTO;
import com.feuji.service.entity.ServiceBusiness;
import com.feuji.service.entity.ServiceBusinessDTO;

@Service
public interface ServiceBusinessService 
{

	ServiceBusinessDTO save(ServiceBusinessDTO serviceBusinessDTO);

	ResponseEntity<Map<String,List<?>>> getAll();

	ServiceBusinessDTO delete(int serviceBusinessId);

	List<com.feuji.service.entity.Service> getServices();

	List<ServiceBusiness> getServiceBusiness(int businessId);

	List<FacilityDTO> getFacilities();

	ServiceBusinessDTO update(ServiceBusinessDTO serviceBusinessDTO);
	
}
