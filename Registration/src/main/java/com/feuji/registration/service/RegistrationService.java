package com.feuji.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.registration.entity.Registration;
import com.feuji.registration.entity.Role;

/**
 * @author Lenovo
 *
 */
@Service
public interface RegistrationService 
{

	Registration save(Registration registration);

	List<Registration> getAll();

	Registration update(Registration registration);

	void delete(int registerId);

	Registration findByEmail(String email);

	Registration findByEmailAndPassword(String email,String password);

	List<Role> getRoles();

	List<Registration> getRequest();
	
	Registration getPlanner(int plannerId);
	
	List<Registration> getPlanner();

}
