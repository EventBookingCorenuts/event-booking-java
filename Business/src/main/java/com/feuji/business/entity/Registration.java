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

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class Registration 
{
	@Id
	@Column(name = "register_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registerId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "contact")
	private double contact;
	
	@Column(name = "active")
	private String active;
}
