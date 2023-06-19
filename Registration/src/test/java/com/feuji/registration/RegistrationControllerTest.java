package com.feuji.registration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.feuji.registration.controller.RegistrationController;
import com.feuji.registration.entity.Registration;
import com.feuji.registration.entity.Role;
import com.feuji.registration.service.RegistrationService;

@SpringBootTest(classes = {RegistrationControllerTest.class})
public class RegistrationControllerTest 
{
	@Mock
	private RegistrationService registrationService;
	
	@InjectMocks
	private RegistrationController registrationController;
	
	//for request api testing
	private MockMvc mockMvc;
		
	//to convert the object into string
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	
	// ------------------------------------ Mock Data ------------------------------------ //
	Registration registration1=new Registration(1, "eventbooking@gmail.com", "Event@123", "false", 3, 9865743245.0, null);
	Registration registration2=new Registration(2, "priya@gmail.com", "Priya@123", "false", 1, 7778891523.0, "true");
	Registration registration3=new Registration(3, "sam@gmail.com", "Sam@1234", "false", 1, 7869504894.0, "true");
	Registration registration4=new Registration(4, "mukesh@gmail.com", "Mukesh@123", "false", 2, 0.0, "false");
	Registration registration5=new Registration(5, "fakki@gamil.com", "Fakki@123", "true", 2, 0.0, null);
	Optional<Registration> registration6=Optional.of(new Registration(6, "borrajumukesh@gmail.com", "Borraju@123", "false", 1, 6758906546.0, "false"));
		
	List<Registration> registrations=Arrays.asList(registration1,registration2,registration3,registration4,registration5,registration6.get());
		
	List<Role> roles=Arrays.asList(new Role(1,"Admin"),new Role(2,"User"),new Role(3,"Admin"));
		
	List<Registration> requests=Arrays.asList(registration5);
	
	@SuppressWarnings("deprecation")
	@BeforeEach //execute before every test case
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(registrationController).build();  //create the mockmvc object
	}
	
	//add the new registration
	@Test
	@Order(1)
	@DisplayName("add-registration")
	public void save() throws Exception
	{
		Mockito.when(this.registrationService.save(registration1)).thenReturn(registration1);
		
		String json=objectMapper.writeValueAsString(registration1);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/registration")
																			.contentType(MediaType.APPLICATION_JSON_VALUE)
																			.accept(MediaType.APPLICATION_JSON_VALUE)
																			.content(json);
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}
	
	//get all the planner data
	@Test
	@Order(2)
	@DisplayName("get-all-records")
	public void getAll() throws Exception
	{
		Mockito.when(this.registrationService.getAll()).thenReturn(registrations);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/registration")
												.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	//update the user information
	@Test
	@Order(3)
	@DisplayName("update-registration")
	public void update() throws Exception
	{
		registration1.setStatus("false");
		Mockito.when(this.registrationService.update(registration1)).thenReturn(registration1);
		
		String json=objectMapper.writeValueAsString(registration1);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.put("/registration")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(json);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}
	
	//get the user data based on email
	@Test
	@Order(4)
	@DisplayName("get-byemail")
	public void findByEmail() throws Exception
	{
		String email="priya@gmail.com";
		Mockito.when(this.registrationService.findByEmail(email)).thenReturn(registration2);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/registration/"+email)
												.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	//get the user data based on email and password
	@Test
	@Order(5)
	@DisplayName("get-byemail-bypassword")
	public void findByEmailAndPassword() throws Exception
	{
		String email="priya@gmail.com";
		String password="Priya@123";
		Mockito.when(this.registrationService.findByEmailAndPassword(email, password)).thenReturn(registration2);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/registration/"+email+"/"+password)
												.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
												
	}
	
	//get all the roles of user
	@Test
	@Order(6)
	@DisplayName("get-roles")
	public void getRoles() throws Exception
	{
		Mockito.when(this.registrationService.getRoles()).thenReturn(roles);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/registration/roles")
												.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	//get the user records who send the request of planner registration
	@Test
	@Order(7)
	@DisplayName("get-request")
	public void getRequest() throws Exception
	{
		Mockito.when(this.registrationService.getRequest()).thenReturn(requests);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/registration/getrequest")
												.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
	//the the all the planner based on their id
	@Test
	@Order(8)
	@DisplayName("get-planner")
	public void getPlanner() throws Exception
	{
		int plannerId=6;
		Mockito.when(this.registrationService.getPlanner(plannerId)).thenReturn(registration6.get());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/registration/planner/"+plannerId)
												.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
}
