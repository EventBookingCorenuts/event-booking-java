package com.feuji.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@NamedQuery(name="Registration.findByEmail",query = "select r from Registration as r where r.email=:email")
@NamedQuery(name = "Registration.findByEmailAndPassword",query = "select r from Registration as r where r.email=:email and password=:password")
@NamedQuery(name = "Registration.findByStatus",query = "select r from  Registration as r where r.status='true'")
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
