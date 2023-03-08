package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.post.PostRequest;
import com.example.DTO.post.PostResponse;
import com.example.service.PostService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PostController {

	@Autowired
	private PostService ps;

	@GetMapping("/postlist")
	@ResponseBody
	public List<PostResponse> postList(HttpServletRequest request){
		return ps.findAll();
		
	}
	
	@GetMapping("/postlistone")
	@ResponseBody
	public PostResponse postListOne(HttpServletRequest request,@RequestParam("id")Long id) {
		return ps.findById(id);
	}
	
	@GetMapping("/postsearchtitle")
	@ResponseBody
	public List<PostResponse> postsearchTitleList(HttpServletRequest request,@RequestParam("title")String title) {
		return ps.findByTitle(title);
		
	}
	@GetMapping("/postsearchcontent")
	@ResponseBody
	public List<PostResponse> postsearchContentList(HttpServletRequest request,@RequestParam("content")String content){
		return ps.findByContent(content);
	}
	
	@PostMapping("/postupdate")
	@ResponseBody
	public Long postUpdate(@RequestBody PostRequest params) {
		return ps.update(params);
	}
	
	@PostMapping("/postsave")
	@ResponseBody
	public Long postSave(@RequestBody PostRequest params) {
		return ps.save(params);
	}
	
	@GetMapping("/postdelete")
	@ResponseBody
	public Long postDelete(HttpServletRequest request,@RequestParam("id")Long id){
		
		return ps.deleteById(id);
	}
	
}
