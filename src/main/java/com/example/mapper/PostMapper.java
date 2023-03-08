package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.post.PostRequest;
import com.example.DTO.post.PostResponse;

@Mapper
public interface PostMapper {
	/*
	 * 게시글 저장 
	 */
	public void save(PostRequest params);
	
	/*
	 * 게시글 리스트 조회
	 */
	public List<PostResponse> findAll();
	/*
	 * 게시글 상세 보기
	 */
	public PostResponse findById(Long id);
	
	/*
	 * 게시글 제목 검색
	 */
	public List<PostResponse> findByTitle(String title);
	
	/*
	 * 게시글 내용 검색
	 */
	public List<PostResponse> findByContent(String content);
	/*
	 * 게시글 수정
	 */
	public void update(PostRequest params);
	
	/*
	 * 게시글 삭제 
	 */
	public void deleteById(Long id);
	
}
