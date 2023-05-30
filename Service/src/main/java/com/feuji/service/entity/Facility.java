package com.feuji.service.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
