package com.feuji.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.registration.entity.Registration;

@Repository
@EnableJpaRepositories
public interface RegistrationRepository extends JpaRepository<Registration, Integer>
{

	Registration findByEmail(String email);

	Registration findByEmailAndPassword(String email, String password);

	List<Registration> findByStatus();
	
	List<Registration> findByRoleId();

}
