package com.feuji.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.service.entity.ServiceBusiness;

@Repository
@EnableJpaRepositories
public interface ServiceBusinessRepository extends JpaRepository<ServiceBusiness, Integer>
{
	List<ServiceBusiness> findByBusinessId(int businessId);
}
