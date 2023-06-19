package com.feuji.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.registration.entity.Role;

/**
 * @author Event Booking Team
 * RoleRepository-->Repository for the Role database operation
 */
@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
