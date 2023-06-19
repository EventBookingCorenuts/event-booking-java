package com.feuji.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.registration.entity.Registration;
import com.feuji.registration.entity.Role;


/**
 * @author Event Booking Team
 * RegistrationService-->All the abstract methods of the api calls
 */
@Service
public interface RegistrationService 
{

	//add the new registration
	Registration save(Registration registration);

	//get all the planner data
	List<Registration> getAll();

	//update the user information
	Registration update(Registration registration);

	//get the user data based on email
	Registration findByEmail(String email);

	//get the user data based on email and password
	Registration findByEmailAndPassword(String email,String password);

	//get all the roles of user
	List<Role> getRoles();

	//get the user records who send the request of planner registration
	List<Registration> getRequest();
	
	//the the all the planner based on their id
	Registration getPlanner(int plannerId);
	
}
