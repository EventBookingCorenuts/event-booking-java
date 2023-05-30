package com.feuji.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.feuji.post.entity.Post;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post, Integer>
{

}
