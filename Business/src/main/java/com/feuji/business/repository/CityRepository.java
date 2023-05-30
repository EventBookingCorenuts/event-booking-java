package com.feuji.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.business.entity.City;

@Repository
@EnableJpaRepositories
public interface CityRepository extends JpaRepository<City, Integer>
{	
	 List<City> findByStateId(int stateId);
}
