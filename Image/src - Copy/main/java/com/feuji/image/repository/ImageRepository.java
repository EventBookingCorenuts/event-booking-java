package com.feuji.image.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.image.entity.Image;
@Repository
@EnableJpaRepositories
public interface ImageRepository  extends JpaRepository<Image, Long>{
    Optional<Image> findByImageName(String fileName);

}
