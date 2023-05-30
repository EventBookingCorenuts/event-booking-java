package com.feuji.post.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feuji.post.dto.Image;
import com.feuji.post.entity.Post;

@Service
public interface PostSevice 
{

	Post save(Post post);

	ResponseEntity<Map<String,List<?>>> getAll();

	void delete(int postId);
	
	Post getPostById(int postId);
	
	void updatePostDescription(int postId,Post post);
	
	List<Image> getImage();
	

}
