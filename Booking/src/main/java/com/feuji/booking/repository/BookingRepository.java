package com.feuji.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.booking.entity.Booking;

@Repository
@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Booking, Integer>
{
	
}
