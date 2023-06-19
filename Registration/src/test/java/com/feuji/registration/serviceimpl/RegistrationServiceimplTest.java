package com.feuji.registration.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.feuji.registration.entity.Registration;
import com.feuji.registration.entity.Role;
import com.feuji.registration.repository.RegistrationRepository;
import com.feuji.registration.repository.RoleRepository;

@SpringBootTest(classes = {RegistrationServiceimplTest.class})
@TestMethodOrder(OrderAnnotation.class)
public class RegistrationServiceimplTest 
{
	@Mock
	private RegistrationRepository registrationRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	private RegistrationServiceIMPL registrationServiceIMPL;
	
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
	
	// ------------------------------- For save()-Add Registration --------------------------------- //
	@Test
	@Order(1)
	@DisplayName("add-registration-1")
	public void save1() //test case 1 for save() method-->add the new registration
	{
		Mockito.when(this.registrationRepository.save(registration1)).thenReturn(registration1);
		Registration actual=this.registrationServiceIMPL.save(registration1);
		assertEquals(registration1, actual);
		assertEquals(registration1.getEmail(), actual.getEmail());
		assertEquals(registration1.getStatus(), actual.getStatus());
	}
	
	@Test
	@Order(2)
	@DisplayName("add-registration-2")
	public void save2() //test case 2 for save() method-->add the new registration
	{
		Mockito.when(this.registrationRepository.save(registration2)).thenReturn(registration2);
		Registration actual=this.registrationServiceIMPL.save(registration2);
		assertEquals(registration2, actual);
		assertEquals(registration2.getEmail(), actual.getEmail());
		assertEquals("Active", actual.getActive());
	}
	
	@Test
	@Order(3)
	@DisplayName("add-registration-3")
	public void save3() //test case 3 for save() method-->add the new registration
	{
		Mockito.when(this.registrationRepository.save(registration4)).thenReturn(registration4);
		Registration actual=this.registrationServiceIMPL.save(registration4);
		assertEquals(registration4, actual);
		assertEquals(registration4.getEmail(), actual.getEmail());
		assertEquals("Inactive", actual.getActive());
	}
	
	// ------------------------------- For getAll()-Add Registration --------------------------------- //
	@Test
	@Order(4)
	@DisplayName("get-all-1")
	public void getAll() //test case 1 for get all the records of registration
	{
		Mockito.when(this.registrationRepository.findAll()).thenReturn(registrations);
		List<Registration> actual=this.registrationServiceIMPL.getAll();
		assertEquals(registrations, actual);
		assertEquals(registrations.size(),actual.size());
		assertEquals(registrations.get(3).getEmail(), actual.get(3).getEmail());
	}
	
	// ------------------------------- For update()-Add Registration --------------------------------- //
	@Test
	@Order(5)
	@DisplayName("update-registration-1")
	public void update1() //test case 1 for update() method-->update the registration
	{
		registration1.setActive("false");
		Mockito.when(this.registrationRepository.save(registration1)).thenReturn(registration1);
		Registration actual=this.registrationServiceIMPL.update(registration1);
		assertEquals(registration1, actual);
		assertEquals(registration1.getEmail(), actual.getEmail());
		assertEquals(registration1.getStatus(), actual.getStatus());
		assertEquals("Inactive", actual.getActive());
	}
	
	// ------------------------------- For findByEmail()-get the registration details based on email --------------------------------- //
	@Test
	@Order(6)
	@DisplayName("find-byemai-1")
	public void findByEmail1() //test case 1 for findByEmail() method--> get the registration details based on email
	{
		String email="priya@gmail.com";
		Mockito.when(this.registrationRepository.findByEmail(email)).thenReturn(registration2);
		Registration actual=this.registrationServiceIMPL.findByEmail(email);
		assertEquals(registration2, actual);
		assertEquals(registration2.getPassword(), actual.getPassword());
		assertEquals(registration2.getContact(), actual.getContact());
	}
	
	@Test
	@Order(7)
	@DisplayName("find-byemai-2")
	public void findByEmail2() //test case 2 for findByEmail() method--> get the registration details based on email
	{
		String email="aditya@gmail.com";
		Mockito.when(this.registrationRepository.findByEmail(email)).thenReturn(null);
		Registration actual=this.registrationServiceIMPL.findByEmail(email);
		assertEquals(null, actual);
	}
	
	// ------------------------------- For findByEmailAndPassword()-get the registration details based on email and password --------------------------------- //
	@Test
	@Order(8)
	@DisplayName("find-byemaiandpassword-1")
	public void findByEmailAndPassword1() //test case 1 for findByEmailAndPassword() method--> get the registration details based on email and password
	{
		String email="priya@gmail.com";
		String password="Priya@123";
		Mockito.when(this.registrationRepository.findByEmailAndPassword(email,password)).thenReturn(registration2);
		Registration actual=this.registrationServiceIMPL.findByEmailAndPassword(email,password);
		assertEquals(registration2, actual);
		assertEquals(registration2.getPassword(), actual.getPassword());
		assertEquals(registration2.getContact(), actual.getContact());
	}
	
	@Test
	@Order(9)
	@DisplayName("find-byemaiandpassword-2")
	public void findByEmailAndPassword2() //test case 2 for findByEmailAndEmail() method--> get the registration details based on email and password
	{
		String email="aditya@gmail.com";
		String password="Aditya@123";
		Mockito.when(this.registrationRepository.findByEmailAndPassword(email,password)).thenReturn(null);
		Registration actual=this.registrationServiceIMPL.findByEmailAndPassword(email,password);
		assertEquals(null, actual);
	}
	
	// ------------------------------- For getRoles()-get all the roles --------------------------------- //
	@Test
	@Order(10)
	@DisplayName("get-roles-1") //test case 1 for getRoles() method--> get the all the roles
	public void getRoles()
	{
		Mockito.when(this.roleRepository.findAll()).thenReturn(roles);
		List<Role> actual=this.registrationServiceIMPL.getRoles();
		assertEquals(roles, actual);
		assertEquals(roles.size(), actual.size());
		assertEquals(roles.get(2).getRoleName(), actual.get(2).getRoleName());
	}
	
	// ------------------------------- For getRequest()-get the registration details based on request send for planner --------------------------------- //
	@Test
	@Order(11)
	@DisplayName("get-request-1")
	public void getRequest() //test case 1 for getRequest() method--> get all the planner request
	{
		Mockito.when(this.registrationRepository.findByStatus()).thenReturn(requests);
		List<Registration> actual=this.registrationServiceIMPL.getRequest();
		assertEquals(requests, actual);
		assertEquals(requests.size(), actual.size());
		assertEquals(requests.get(0).getEmail(), actual.get(0).getEmail());
	}
	
	// ------------------------------- For getPlanner()-get all the planners --------------------------------- //
	@Test
	@Order(12)
	@DisplayName("get-request-1")
	public void getPlanner() //test case 1 for getPlanner() method --> get all the planner
	{
		int plannerId=6;
		Mockito.when(this.registrationRepository.findById(plannerId)).thenReturn(registration6);
		Registration actual=this.registrationServiceIMPL.getPlanner(plannerId);
		assertEquals(registration6.get(), actual);
		assertEquals(registration6.get().getEmail(), actual.getEmail());
	}
}
