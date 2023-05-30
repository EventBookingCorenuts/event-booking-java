package com.feuji.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.business.dto.BusinessDTO;
import com.feuji.business.entity.Business;
import com.feuji.business.entity.City;
import com.feuji.business.entity.State;

@Service
public interface BusinessService 
{

	BusinessDTO save(BusinessDTO  businessDTO);

	List<Business> getAll();

	void delete(int businessId);

	List<State> getStates();

	List<City> getCity(int stateId);

	List<City> getCity();

	List<BusinessDTO> getBusiness();

	BusinessDTO get(int registerId);

}
