package com.feuji.image.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="image")
@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Image
{
	@Id
	@Column(name="image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="image_type")
	private String imageType;
	
	@Column(name="image_data",length=1000)
	@Lob
	private byte[] imageData;
}
