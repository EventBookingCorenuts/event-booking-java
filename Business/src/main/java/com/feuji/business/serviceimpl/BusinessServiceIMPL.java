package com.feuji.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.business.dto.BusinessDTO;
import com.feuji.business.entity.Business;
import com.feuji.business.entity.City;
import com.feuji.business.entity.Location;
import com.feuji.business.entity.State;
import com.feuji.business.repository.BusinessRepository;
import com.feuji.business.repository.CityRepository;
import com.feuji.business.repository.StateRepository;
import com.feuji.business.service.BusinessService;

@Service
public class BusinessServiceIMPL implements BusinessService
{
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private Business business;
	
	@Autowired
	private Location location;

	@Override
	public BusinessDTO save(BusinessDTO businessDTO) 
	{
		location.setLocationId(businessDTO.getLocationId());
		location.setCityId(businessDTO.getCityId());
		location.setPincode(businessDTO.getPincode());
		
		business.setBusinessId(businessDTO.getBusinessId());
		business.setBusinessName(businessDTO.getBusinessName());
		business.setDescription(businessDTO.getDescription());
		business.setRegisterId(businessDTO.getRegisterId());
		
		business.setImageId(businessDTO.getImageId());
		business.setLocationId(location);
		business = businessRepository.save(business);
		businessDTO.setBusinessId(business.getBusinessId());
		return businessDTO; 
	}

	@Override
	public List<Business> getAll()
	{
		return businessRepository.findAll();
	}

	@Override
	public void delete(int businessId)
	{
		businessRepository.deleteById(businessId);
	}

	@Override
	public List<State> getStates() 
	{
		return stateRepository.findAll();
	}

	@Override
	public List<City> getCity(int stateId) 
	{
		return cityRepository.findByStateId(stateId);
	}

	@Override
	public List<City> getCity() 
	{
		return cityRepository.findAll(); 
	}

	@Override
	public List<BusinessDTO> getBusiness() 
	{
		List<Business> businesses = businessRepository.findAll();
		List<BusinessDTO> businessList=new ArrayList<>();
		for(Business business :  businesses)
		{
			BusinessDTO businessDTO = new BusinessDTO();
			businessDTO.setBusinessId(business.getBusinessId());
			businessDTO.setBusinessName(business.getBusinessName());
			businessDTO.setDescription(business.getDescription());
			businessDTO.setRegisterId(business.getRegisterId());
			businessDTO.setLocationId(business.getLocationId().getLocationId());
			businessDTO.setCityId(business.getLocationId().getCityId());
			businessDTO.setPincode(business.getLocationId().getPincode());
			businessDTO.setImageId(business.getImageId());
			businessList.add(businessDTO);
		}
		return businessList;
	}

	@Override
	public BusinessDTO get(int registerId) 
	{
		Business business=businessRepository.findByRegisterId(registerId);
		BusinessDTO businessDTO = new BusinessDTO();
		businessDTO.setBusinessId(business.getBusinessId());
		businessDTO.setBusinessName(business.getBusinessName());
		businessDTO.setDescription(business.getDescription());
		businessDTO.setRegisterId(business.getRegisterId());
		businessDTO.setLocationId(business.getLocationId().getLocationId());
		businessDTO.setCityId(business.getLocationId().getCityId());
		businessDTO.setImageId(business.getImageId());
		businessDTO.setPincode(business.getLocationId().getPincode());
		return businessDTO;
	}
}
