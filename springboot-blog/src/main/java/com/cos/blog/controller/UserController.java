package com.cos.blog.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.blog.model.RespCM;
import com.cos.blog.model.ReturnCode;
import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.model.user.dto.ReqLoginDto;
import com.cos.blog.service.UserService;

@Controller
public class UserController {
	
	@Value("${file.path}")
	private String fileRealPath;  // 서버에 배포하면 경로 변경해야함.
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private User principal;
	
	@GetMapping("/user/join")
	public String join() {
		return "/user/join";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}

//	@GetMapping("/user/logout")
//	public String logout() {
//		session.invalidate();
//		return "redirect:/";
//	}
	
	// 인증, 동일인 체크
	@GetMapping("/user/profile/{id}")
	public  String profile(@PathVariable int id, @AuthenticationPrincipal User principal) {
		
//		User principal = (User) session.getAttribute("principal");
		
		System.out.println("UserController : profile :  "+principal.getProfile());
		if(principal.getId() == id) {
			return "/user/profile";
		}else {
			// 잘못된 접근입니다. 권한이 없습니다.
			return "/user/login";
		}
	
	}
	
	// form:form 사용함!!
	@PutMapping("/user/profile")
	public @ResponseBody String profile(
			@RequestParam int id, 
			@RequestParam String password,
			@RequestParam MultipartFile profile, @AuthenticationPrincipal User principal){
		
		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid+"_"+profile.getOriginalFilename();
		
		// nio 객체!!
		Path filePath = Paths.get(fileRealPath+uuidFilename);
		try {
			Files.write(filePath, profile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = userService.수정완료(id, password, uuidFilename, principal);
		
		StringBuffer sb = new StringBuffer();
		if(result == 1) {
			sb.append("<script>");
			sb.append("alert('수정완료');");
			sb.append("location.href='/';");
			sb.append("</script>");
			return sb.toString();
		}else {
			sb.append("<script>");
			sb.append("alert('수정실패');");
			sb.append("history.back();");
			sb.append("</script>");
			return sb.toString();
		}	

	}
	
	// 메시지 컨버터(Jackson Mapper)는 request받을 때 setter로 호출한다.
	@PostMapping("/user/join")
	public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDto dto, BindingResult bindingResult) {
		int result = userService.회원가입(dto);
		
		if(result == ReturnCode.아이디중복) {
			return new ResponseEntity<RespCM>(new RespCM(ReturnCode.아이디중복, "아이디중복"), HttpStatus.OK);
		}else if(result == ReturnCode.성공) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
//	@PostMapping("/user/login")
//	public ResponseEntity<?> login(
//			@Valid @RequestBody ReqLoginDto dto, 
//			BindingResult bindingResult
//			) {
//		
//		// request 검증 = AOP로 처리할 예정
//		
//		// 서비스 호출
//		User principal = userService.로그인(dto);
//
//		if(principal != null) {
////			session.setAttribute("principal", principal);
//			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
//		}
//		
//	}
}