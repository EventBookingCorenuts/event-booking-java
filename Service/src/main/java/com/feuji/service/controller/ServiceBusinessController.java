package com.feuji.service.controller;

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

import com.feuji.service.entity.FacilityDTO;
import com.feuji.service.entity.Service;
import com.feuji.service.entity.ServiceBusiness;
import com.feuji.service.entity.ServiceBusinessDTO;
import com.feuji.service.service.ServiceBusinessService;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceBusinessController
{
	@Autowired
	private ServiceBusinessService serviceBusinessService;
	
	//add service
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceBusinessDTO save(@RequestBody ServiceBusinessDTO serviceBusinessDTO)
	{
		return serviceBusinessService.save(serviceBusinessDTO);
	}
	
	//get all the services with registration and all rest template
	@GetMapping()
	public ResponseEntity<Map<String,List<?>>> getAll()
	{
		return serviceBusinessService.getAll();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody ServiceBusinessDTO serviceBusinessDTO)
	{
		serviceBusinessService.update(serviceBusinessDTO);
	}
	
	//delete the service based on serviceId
	@DeleteMapping("{serviceBusinessId}")
	public ServiceBusinessDTO delete(@PathVariable(value = "serviceBusinessId") int serviceBusinessId)
	{
		return serviceBusinessService.delete(serviceBusinessId);
	}
	
	//get all services
	@GetMapping("/getservices")
	public List<Service> getServices()
	{
		return serviceBusinessService.getServices();
	}
	
	@GetMapping("{businessId}")
	public List<ServiceBusiness> getServiceBusiness(@PathVariable(value = "businessId") int businessId)
	{
		return serviceBusinessService.getServiceBusiness(businessId);
	}
	
	//get all the facilities
	@GetMapping("/facilities")
	public List<FacilityDTO> getFacilities()
	{
		return serviceBusinessService.getFacilities();
	}
}
