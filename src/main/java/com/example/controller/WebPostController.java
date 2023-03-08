package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DTO.post.PostResponse;
import com.example.service.PostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebPostController {

	private PostService postService;
	
	@GetMapping("/post/write.do")
	public String openPostWrite(Model model) {
		String title="제목"
				,content="내용"
				,writer ="홍길동";
		model.addAttribute("t", title);
		model.addAttribute("c", content);
		model.addAttribute("w", writer);
		return "post/write";
	}
	
	@GetMapping("/post/swrite.do")
	public String openPostSWrite(@RequestParam(value="id", required=false)Long id, Model model) {
		if(id!=null) {
			PostResponse post = postService.findById(id);
			model.addAttribute("post", post);
			
		}
		return "post/swrite";
	}
	
	public void openSession(HttpServletRequest request) {
		String id="admin";
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.getAttribute("id");
	}
}
