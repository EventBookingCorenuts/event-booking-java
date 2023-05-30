package com.feuji.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController 
{
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Registration save(@RequestBody Registration registration)
	{
		return registrationService.save(registration);
	}
	
	@GetMapping()
	public List<Registration> getAll()
	{
		return registrationService.getAll();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Registration update(@RequestBody Registration registration)
	{
		return registrationService.update(registration);
	}
	
	@DeleteMapping("{registerId}")
	public void delete(@PathVariable(value = "registerId") int registerId)
	{
		registrationService.delete(registerId);
	}
	
	@GetMapping("{email}")
	public Registration findByEmail(@PathVariable String email)
	{
		return registrationService.findByEmail(email);
	}
	
	@GetMapping("{email}/{password}")
	public Registration findByEmail(@PathVariable String email,@PathVariable String password)
	{
		return registrationService.findByEmailAndPassword(email,password);
	}
	
	@GetMapping(value = "/roles")
	public List<Role> getRoles()
	{
		return registrationService.getRoles();
	}
	
	@GetMapping(value = "/getrequest")
	public List<Registration> getRequest()
	{
		return registrationService.getRequest();
	}
	
	@GetMapping(value = "/planner/{plannerId}")
	public Registration getPlanner(@PathVariable(name = "plannerId") int plannerId)
	{
		return registrationService.getPlanner(plannerId);
	}
	
	@GetMapping(value = "/plannerid")
	public List<Registration> getPlanner()
	{
		return registrationService.getPlanner();
	}
}
