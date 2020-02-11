package com.cos.blog.model.comment.dto;

import java.sql.Timestamp;

import com.cos.blog.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespDetailDto {// 익스텐즈로 상속해도 됨
	
	private RespCM status;
	
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	private String username;
}
