package com.feuji.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.business.entity.Business;

@Repository
@EnableJpaRepositories
public interface BusinessRepository extends JpaRepository<Business, Integer>
{
	Business findByRegisterId(int registerId);
}
