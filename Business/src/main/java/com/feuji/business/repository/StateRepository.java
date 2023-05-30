package com.feuji.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.business.entity.State;

@Repository
@EnableJpaRepositories
public interface StateRepository extends JpaRepository<State, Integer>
{

}
