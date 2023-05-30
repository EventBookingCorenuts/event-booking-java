package com.feuji.business.entity;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@NamedQuery(name="Business.findByRegisterId",query = "select b from Business as b where b.registerId=:registerId")
public class Business 
{
	@Id
	@Column(name = "business_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int businessId;
	
	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id",referencedColumnName = "location_id")
	private Location locationId;
	
	@Column(name = "register_id")
	private int registerId;
	
	@Column(name = "image_id")
	private int imageId;
}
