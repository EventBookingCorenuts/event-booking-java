package com.feuji.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Location 
{
	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "pincode")
	private int pincode;
}
