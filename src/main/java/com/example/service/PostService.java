package com.example.service;

import java.util.List;

import com.example.DTO.post.PostRequest;
import com.example.DTO.post.PostResponse;

public interface PostService {
	public List<PostResponse> findAll();
	public PostResponse findById(Long id);
	public List<PostResponse> findByTitle(String title);
	public List<PostResponse> findByContent(String content);
	public Long update(PostRequest params);
	public Long save(PostRequest params);
	public Long deleteById(Long id);
}
