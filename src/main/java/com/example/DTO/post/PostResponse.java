package com.example.DTO.post;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostResponse {
	private Long id;//PK
	private String title;//제목
	private String content;//내용
	private String writer;//작성자
	private int viewCnt;//조회 수
	private Boolean noticeYn;//공지글여부
	private Boolean deleteYn;//삭제여부
	private LocalDateTime createdDate;//생성일시
	private LocalDateTime modifiedData;//최종 수정일시
}
