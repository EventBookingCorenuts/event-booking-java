package com.feuji.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@NamedQuery(name="City.findByStateId",query = "select c from City as c where c.stateId=:stateId")
public class City 
{
	@Id
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "state_id")
	private int stateId;
}
