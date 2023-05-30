package com.feuji.service.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.service.dto.BusinessDTO;
import com.feuji.service.entity.Facility;
import com.feuji.service.entity.FacilityDTO;
import com.feuji.service.entity.ServiceBusiness;
import com.feuji.service.entity.ServiceBusinessDTO;
import com.feuji.service.repository.FacilityRepository;
import com.feuji.service.repository.ServiceBusinessRepository;
import com.feuji.service.repository.ServiceRepository;
import com.feuji.service.service.ServiceBusinessService;
import com.feuji.service.utils.ServiceUtil;

@Service
public class ServiceBusinessServiceIMPL implements ServiceBusinessService
{
	@Autowired
	private ServiceBusinessRepository serviceBusinessRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ServiceBusiness serviceBusiness2;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private ServiceUtil serviceUtil;
	
	@Override
	public ServiceBusinessDTO save(ServiceBusinessDTO serviceBusinessDTO) 
	{	
		serviceBusiness2.setServiceBusinessId(serviceBusinessDTO.getServiceBusinessId());
		serviceBusiness2.setServiceId(serviceBusinessDTO.getServiceId());
		serviceBusiness2.setBusinessId(serviceBusinessDTO.getBusinessId());
		serviceBusiness2.setCost(serviceBusinessDTO.getCost());
		serviceBusiness2=serviceBusinessRepository.save(serviceBusiness2);
		List<FacilityDTO> facilities = serviceBusinessDTO.getFacilities();
		List<Facility> facilities1=new ArrayList<>();
		for(FacilityDTO facility:facilities)
		{
			Facility facility2=new Facility();
			facility2.setFacilityId(facility.getFacilityId());
			facility2.setFacilityName(facility.getFacilityName());	
			facility2.setServiceBusinessId(serviceBusiness2);
			facilities1.add(facility2);
		}
		facilities1=facilityRepository.saveAll(facilities1);
		serviceBusiness2.setFacilities(facilities1);
		
		serviceBusinessDTO.setServiceBusinessId(serviceBusiness2.getServiceBusinessId());
		serviceBusinessDTO.setBusinessId(serviceBusiness2.getBusinessId());
		serviceBusinessDTO.setServiceId(serviceBusiness2.getServiceId());
		serviceBusinessDTO.setCost(serviceBusiness2.getCost());
		List<FacilityDTO> facilityDTOs=new ArrayList<>();
		for(Facility facility:serviceBusiness2.getFacilities())
		{
			FacilityDTO facility2=new FacilityDTO();
			facility2.setFacilityId(facility.getFacilityId());
			facility2.setFacilityName(facility.getFacilityName());
			facility2.setServiceBusinessId(facility.getServiceBusinessId().getServiceBusinessId());
			facilityDTOs.add(facility2);
		}
		serviceBusinessDTO.setFacilities(facilityDTOs);
		return serviceBusinessDTO;
	}

	@Override
	public ResponseEntity<Map<String,List<?>>> getAll() 
	{
		List<ServiceBusiness> serviceBusinesses = serviceBusinessRepository.findAll();
		RestTemplate resttemplate=new RestTemplate();
		ResponseEntity<BusinessDTO[]> businessesResponse=resttemplate.getForEntity("http://"+serviceUtil.getUrl()+":9062/api/business/getbusiness",BusinessDTO[].class);
		BusinessDTO[] businessesArray=businessesResponse.getBody();
		List<BusinessDTO> businesses=Arrays.asList(businessesArray);
		
		Map<String,List<?>> response=new HashMap<>();
		response.put("serviceBuiness", serviceBusinesses);
		response.put("businesses", businesses);
		return ResponseEntity.ok(response);
	}

	@Override
	public ServiceBusinessDTO delete(int serviceBusinessId) 
	{
		serviceBusiness2=serviceBusinessRepository.findById(serviceBusinessId).get();
		List<Facility> facilities = serviceBusiness2.getFacilities();
		ServiceBusinessDTO serviceBusinessDTO=new ServiceBusinessDTO();
		serviceBusinessDTO.setServiceBusinessId(serviceBusiness2.getServiceBusinessId());
		serviceBusinessDTO.setBusinessId(serviceBusiness2.getBusinessId());
		serviceBusinessDTO.setServiceId(serviceBusiness2.getServiceId());
		serviceBusinessDTO.setCost(serviceBusiness2.getCost());
		List<FacilityDTO> facilityDTOs=new ArrayList<>();
		for(Facility facility:facilities)
		{
			FacilityDTO facilityDTO=new FacilityDTO();
			facilityDTO.setFacilityId(facility.getFacilityId());
			facilityDTO.setFacilityName(facility.getFacilityName());
			facilityDTO.setServiceBusinessId(facility.getServiceBusinessId().getServiceBusinessId());
			facilityDTOs.add(facilityDTO);
		}
		serviceBusinessDTO.setFacilities(facilityDTOs);
		facilityRepository.deleteAll(facilities);
		serviceBusinessRepository.deleteById(serviceBusinessId);
		return serviceBusinessDTO;
	}

	@Override
	public List<com.feuji.service.entity.Service> getServices() 
	{
		return serviceRepository.findAll();
	}

	@Override
	public List<ServiceBusiness> getServiceBusiness(int businessId) 
	{
		return serviceBusinessRepository.findByBusinessId(businessId);
	}

	@Override
	public List<FacilityDTO> getFacilities() 
	{
		List<Facility> facilities = facilityRepository.findAll();
		List<FacilityDTO> facilities1 = new ArrayList<>();
		for(Facility facility:facilities)
		{
			FacilityDTO facilityDTO=new FacilityDTO();
			facilityDTO.setFacilityId(facility.getFacilityId());
			facilityDTO.setFacilityName(facility.getFacilityName());
			facilityDTO.setServiceBusinessId(facility.getServiceBusinessId().getServiceBusinessId());
			facilities1.add(facilityDTO);
		}
		return facilities1;
	}
	
	@Override
	public ServiceBusinessDTO update(ServiceBusinessDTO serviceBusinessDTO) 
	{	
		
		serviceBusiness2.setServiceBusinessId(serviceBusinessDTO.getServiceBusinessId());
		serviceBusiness2.setServiceId(serviceBusinessDTO.getServiceId());
		serviceBusiness2.setBusinessId(serviceBusinessDTO.getBusinessId());
		serviceBusiness2.setCost(serviceBusinessDTO.getCost());
		serviceBusiness2=serviceBusinessRepository.save(serviceBusiness2);
		List<Facility> facility=facilityRepository.findByServiceBusinessId(serviceBusiness2);
		facilityRepository.deleteAll(facility);
		List<FacilityDTO> facilities = serviceBusinessDTO.getFacilities();
		List<Facility> facilities1=new ArrayList<>();
		for(FacilityDTO faci:facilities)
		{
			Facility facility2=new Facility();
			facility2.setFacilityId(faci.getFacilityId());
			facility2.setFacilityName(faci.getFacilityName());	
			facility2.setServiceBusinessId(serviceBusiness2);
			facilities1.add(facility2);
		}
		facilities1=facilityRepository.saveAll(facilities1);
		serviceBusiness2.setFacilities(facilities1);
		
		serviceBusinessDTO.setServiceBusinessId(serviceBusiness2.getServiceBusinessId());
		serviceBusinessDTO.setBusinessId(serviceBusiness2.getBusinessId());
		serviceBusinessDTO.setServiceId(serviceBusiness2.getServiceId());
		serviceBusinessDTO.setCost(serviceBusiness2.getCost());
		List<FacilityDTO> facilityDTOs=new ArrayList<>();
		for(Facility faci:serviceBusiness2.getFacilities())
		{
			FacilityDTO facility2=new FacilityDTO();
			facility2.setFacilityId(faci.getFacilityId());
			facility2.setFacilityName(faci.getFacilityName());
			facility2.setServiceBusinessId(faci.getServiceBusinessId().getServiceBusinessId());
			facilityDTOs.add(facility2);
		}
		serviceBusinessDTO.setFacilities(facilityDTOs);
		return serviceBusinessDTO;
	}
}
