package com.feuji.service.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service_business")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@NamedQuery(name = "ServiceBusiness.findByBusinessId",query = "select sc from ServiceBusiness as sc where sc.businessId=:businessId")
public class ServiceBusiness 
{
	@Id
	@Column(name = "service_business_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceBusinessId;
	
	@Column(name = "service_id")
	private int serviceId;
	
	@Column(name = "business_id")
	private int businessId;
	
	@Column(name = "cost")
	private double cost;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceBusinessId")
	private List<Facility> facilities;
}
