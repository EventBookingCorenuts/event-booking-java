package com.feuji.service.entity;


import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "facility")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Facility.findByServiceBusinessId",query = "select b from Facility as b where b.serviceBusinessId=:serviceBusinessId")
public class Facility 
{
	@Id
	@Column(name = "facility_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int facilityId;
	
	@Column(name = "facility_name")
	private String facilityName;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_business_id",referencedColumnName = "service_business_id")
	private ServiceBusiness serviceBusinessId;
}
