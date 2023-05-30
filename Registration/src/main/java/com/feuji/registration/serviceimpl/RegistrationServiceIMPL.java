package com.feuji.registration.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.registration.entity.Registration;
import com.feuji.registration.entity.Role;
import com.feuji.registration.repository.RegistrationRepository;
import com.feuji.registration.repository.RoleRepository;
import com.feuji.registration.service.RegistrationService;

@Service
public class RegistrationServiceIMPL implements RegistrationService
{
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired 
	private RoleRepository roleRepository;

	@Override
	public Registration save(Registration registration)
	{
		if("true".equals(registration.getActive()))
		{	
			registration.setActive("Active");
		}
		if("false".equals(registration.getActive()))
		{	
			registration.setActive("Inactive");
		}
		return registrationRepository.save(registration);
	}

	@Override
	public List<Registration> getAll() 
	{
		List<Registration> registrations = registrationRepository.findAll();
		List<Registration> registrations2=registrations.stream().map(r->{
			if("Active".equals(r.getActive()))
				r.setActive("true");
			else if("Inactive".equals(r.getActive()))
				r.setActive("false");
			return r;
		}).collect(Collectors.toList());
		return registrations2;
	}

	@Override
	public Registration update(Registration registration) 
	{
		return registrationRepository.save(registration);
	}

	@Override
	public void delete(int registerId)
	{
		registrationRepository.deleteById(registerId);
	}

	@Override
	public Registration findByEmail(String email) 
	{
		return registrationRepository.findByEmail(email);
	}

	@Override
	public Registration findByEmailAndPassword(String email,String password) 
	{
		return registrationRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public List<Role> getRoles() 
	{
		return roleRepository.findAll();
	}

	@Override
	public List<Registration> getRequest()
	{
		return registrationRepository.findByStatus();
	}

	@Override
	public Registration getPlanner(int plannerId)
	{
		return registrationRepository.findById(plannerId).get();
	}
	
	@Override
	public List<Registration> getPlanner()
	{
		return registrationRepository.findByRoleId();
	}
	
}
