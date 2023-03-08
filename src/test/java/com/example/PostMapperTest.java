package com.example;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DTO.post.PostRequest;
import com.example.DTO.post.PostResponse;
import com.example.mapper.PostMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@SpringBootTest
public class PostMapperTest {
	@Autowired
	PostMapper postMapper;
	
	@Test
	void save() {
		PostRequest params = new PostRequest();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");
		params.setNoticeYn(false);
		postMapper.save(params);
		
		List<PostResponse> posts = postMapper.findAll();
		System.out.println("전체 게시글 개수는 :"+posts.size()+"개입니다.");
	}
	
	@Test
	void findById() {
		PostResponse post = postMapper.findById(1L);
		try {
			
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
			System.out.println(postJson);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void update() {
		PostRequest params = new PostRequest();
		params.setId(1L);
		params.setTitle("1번 게시글 제목 수정합니다.");
		params.setContent("1번 게시글 내용 수정합니다.");
		params.setWriter("도떵이");
		params.setNoticeYn(true);
		postMapper.update(params);
		PostResponse post = postMapper.findById(1L);
		try {
			
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
			System.out.println(postJson);
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	@Test
	void delete() {
		System.out.println("삭제 이전의 전체 게시글 개수는:"+postMapper.findAll().size()+"개입니다.");
		postMapper.deleteById(1L);
		System.out.println("삭제 이후의 전체 게시글 개수는:"+postMapper.findAll().size()+"개입니다.");
		
	}
	
	@Test
	void findByTitle()  {
		String title="1번 게시글 제목";
		List<PostResponse> posts = postMapper.findByTitle(title);

		try {
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(posts);
			System.out.println(postJson);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	void findByContent() {
		String content="게시글";
		List<PostResponse> posts = postMapper.findByContent(content);
		try {
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(posts);
			System.out.println(postJson);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
