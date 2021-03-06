package com.cos.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestMemUpdateDto{
	private int id;
	private String password;
	private String email;
}
