package com.feuji.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.service.entity.Service;

@Repository@EnableJpaRepositories
public interface ServiceRepository extends JpaRepository<Service, Integer>
{
	
}
