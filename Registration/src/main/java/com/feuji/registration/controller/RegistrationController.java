package com.feuji.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.registration.entity.Registration;
import com.feuji.registration.entity.Role;
import com.feuji.registration.service.RegistrationService;


/**
 * @author Event Booking Team
 *	RegistrationController-->All the api which is related to Registration of User
 */
@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController 
{
	@Autowired
	private RegistrationService registrationService;
	
	//add the new registration
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Registration save(@RequestBody Registration registration)
	{
		return registrationService.save(registration);
	}
	
	//get all the planner data
	@GetMapping()
	public List<Registration> getAll()
	{
		return registrationService.getAll();
	}
	
	//update the user information
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Registration update(@RequestBody Registration registration)
	{
		return registrationService.update(registration);
	}
	
	//get the user data based on email
	@GetMapping("{email}")
	public Registration findByEmail(@PathVariable String email)
	{
		return registrationService.findByEmail(email);
	}
	
	//get the user data based on email and password
	@GetMapping("{email}/{password}")
	public Registration findByEmailAndPassword(@PathVariable String email,@PathVariable String password)
	{
		return registrationService.findByEmailAndPassword(email,password);
	}
	
	//get all the roles of user
	@GetMapping(value = "/roles")
	public List<Role> getRoles()
	{
		return registrationService.getRoles();
	}
	
	//get the user records who send the request of planner registration
	@GetMapping(value = "/getrequest")
	public List<Registration> getRequest()
	{
		return registrationService.getRequest();
	}
	
	//the the all the planner based on their id
	@GetMapping(value = "/planner/{plannerId}")
	public Registration getPlanner(@PathVariable(name = "plannerId") int plannerId)
	{
		return registrationService.getPlanner(plannerId);
	}
}
