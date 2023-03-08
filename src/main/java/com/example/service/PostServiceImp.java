package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DTO.post.PostRequest;
import com.example.DTO.post.PostResponse;
import com.example.mapper.PostMapper;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostMapper m;
	
	@Override
	public List<PostResponse> findAll() {

		return m.findAll();
	}

	@Override
	public PostResponse findById(Long id) {
		// TODO Auto-generated method stub
		return m.findById(id);
	}

	@Override
	public List<PostResponse> findByTitle(String title) {
		// TODO Auto-generated method stub
		return m.findByTitle(title);
	}

	@Override
	public List<PostResponse> findByContent(String content) {
		// TODO Auto-generated method stub
		return m.findByContent(content);
	}

	@Transactional	
	public Long update(PostRequest params) {
		// TODO Auto-generated method stub
		m.update(params);
		return params.getId();
	}

	@Transactional	
	public Long save(PostRequest params) {
		m.save(params);
		return params.getId();
	}

	@Transactional	
	public Long deleteById(Long id) {
		m.deleteById(id);
		return id;
	}

}
