package com.feuji.post.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.feuji.post.dto.BusinessDTO;
import com.feuji.post.dto.Image;
import com.feuji.post.entity.Post;
import com.feuji.post.service.PostSevice;
import com.feuji.post.utils.PostUtil;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController
{
	@Autowired
	private PostSevice postSevice;
	
	@Autowired
	private PostUtil postUtil;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Post save(@RequestBody Post post)
	{
		return postSevice.save(post);
	}
	
	@GetMapping()
	public ResponseEntity<Map<String,List<?>>> getAll()
	{
		return postSevice.getAll();
	}
	
	@GetMapping("{postId}")
	public Post getPostById(@PathVariable(value="postId") int postId)
	{
		 return postSevice.getPostById(postId);
	}

	@PutMapping("{postId}")
	public void update(@PathVariable(value="postId") int postId ,@RequestBody Post post)
	{
		postSevice.updatePostDescription(postId, post);
	}
	
	@DeleteMapping("{postId}")
	public void delete(@PathVariable(value = "postId") int postId)
	{
		postSevice.delete(postId);
	}
	
	@GetMapping("/business")
	public BusinessDTO getBusiness()
	{
		return restTemplate.getForObject("http://"+postUtil.getUrl()+":9062/api/business", BusinessDTO.class);
	}
	
	@PostMapping("/image")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile image) throws IOException
	{
		return restTemplate.postForEntity("http://"+postUtil.getUrl()+":9066/api/image", image, ResponseEntity.class);
	}
	
	@GetMapping("/getImage")
	public List<Image> getImageById() 
	{
		return postSevice.getImage();
	}

}
