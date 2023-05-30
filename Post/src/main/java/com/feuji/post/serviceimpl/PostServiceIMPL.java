package com.feuji.post.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.post.dto.BusinessDTO;
import com.feuji.post.dto.Image;
import com.feuji.post.entity.Post;
import com.feuji.post.repository.PostRepository;
import com.feuji.post.service.PostSevice;
import com.feuji.post.utils.PostUtil;

@Service
public class PostServiceIMPL implements PostSevice
{
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	private PostUtil postUtil;
	
	@Override
	public Post save(Post post) 
	{
		return postRepository.save(post);
	}

	@Override
	public ResponseEntity<Map<String,List<?>>> getAll() 
	{
		List<Post> posts = postRepository.findAll();
		RestTemplate resttemplate=new RestTemplate();
		ResponseEntity<BusinessDTO[]> businessesResponse=resttemplate.getForEntity("http://"+postUtil.getUrl()+":9062/api/business/getbusiness",BusinessDTO[].class);
		BusinessDTO[] businessesArray=businessesResponse.getBody();
		List<BusinessDTO> businesses=Arrays.asList(businessesArray);
		Map<String,List<?>> response=new HashMap<>();
		response.put("posts", posts);
		response.put("businesses", businesses);
		return ResponseEntity.ok(response);
	}

	@Override
	public void delete(int postId) 
	{
		postRepository.deleteById(postId);
	}
	
	@Override
	public Post getPostById(int postId)
	{
		 return postRepository.findById(postId).get();
	}

	@Override
	public void updatePostDescription(int postId, Post post) 
	{
		Post post1=new Post();
		Post post2=postRepository.findById(postId).get();
		post1.setPostId(postId);
		post1.setBusinessId(post2.getBusinessId());
		post1.setDescription(post.getDescription());
		postRepository.save(post1);
	}

	@Override
	public List<Image> getImage()
	{
		List<Post> posts= postRepository.findAll();
		List<Image> images=new ArrayList<>();
		for(Post post:posts ) 
		{
			Image image = resttemplate.getForObject("http://"+postUtil.getUrl()+":9066/api/image/"+post.getImageId(),Image.class );
			images.add(image);
		}
		return images;
	}
}
