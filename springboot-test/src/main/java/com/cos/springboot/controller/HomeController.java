package com.cos.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestMemberDto;
import com.cos.springboot.dto.RequestUserDto;
import com.cos.springboot.dto.ResponseData;

@Controller
@RequestMapping("/home")
public class HomeController {

	// localhost:8080/home/
	// localhost:8080/home
	@GetMapping({ "", "/" })
	public String Home() {
		return "home";
	}

	// localhost:8080/home/hello
	@GetMapping("/hello")
	public String hello_get() {
		// DB Select - model 데이터 필요하면 셀렉트해서 모델에 담고 없으면 그냥 이동
		return "hello";
	}
	
	@PostMapping("/hello")
	public @ResponseBody ResponseData hello_post(@RequestBody RequestUserDto requestUserDto) {
		// DB insert            주소는 똑같아도 메소드 방식에 의해 따로 호출
		System.out.println(requestUserDto.getId());
		return new ResponseData(200, "ok");
	}
	
	@DeleteMapping("/hello")
	public @ResponseBody ResponseData hello_delete(@RequestBody RequestUserDto requestUserDto) {
		System.out.println(requestUserDto.getId());
		// DB delete 로직이 필요
		return new ResponseData(200, "ok");
	}
	
	@PutMapping("/hello")
	public @ResponseBody ResponseData hello_put(@RequestBody RequestMemberDto requestMemberDto) {
		System.out.println(requestMemberDto.getUsername());
		System.out.println(requestMemberDto.getPhone());
		// DB update
		return new ResponseData(200, "ok");
	}
}
