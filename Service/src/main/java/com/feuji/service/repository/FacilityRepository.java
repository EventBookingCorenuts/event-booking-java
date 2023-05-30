package com.feuji.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.service.entity.Facility;
import com.feuji.service.entity.ServiceBusiness;

@Repository
@EnableJpaRepositories
public interface FacilityRepository extends JpaRepository<Facility, Integer>
{
   List<Facility> findByServiceBusinessId(ServiceBusiness serviceBusinessId);            
}
