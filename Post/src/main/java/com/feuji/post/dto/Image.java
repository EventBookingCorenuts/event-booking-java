package com.feuji.post.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="image")
@Builder
public class Image
{
	@Id
	@Column(name="image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="image_type")
	private String imageType;
	
	@Column(name="image_data",length=1000)
	@Lob
	private byte[] imageData;
}
