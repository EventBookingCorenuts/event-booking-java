package com.feuji.business.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
