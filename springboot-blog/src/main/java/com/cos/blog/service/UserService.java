package com.cos.blog.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.ReturnCode;
import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.model.user.dto.ReqLoginDto;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// result = 0 비정상, 1 정상, -1 DB 오류, -2 아이디 중복
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			
			if(result == 1) {
				return ReturnCode.아이디중복;
			}else {
				// password 암호화 하기!!
				// 비밀번호가 패스워드 인코딩 안되있음 서버오류난다 
				String encodePassword = passwordEncoder.encode(dto.getPassword());
				// 암호화 되서 들어가진다.
				dto.setPassword(encodePassword);
				return userRepository.save(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public User 로그인(ReqLoginDto dto) {
		return userRepository.findByUsernameAndPassword(dto);
	}
	
	public int 수정완료(int id, String password, String profile, User principal) {
		
		String encodePassword = passwordEncoder.encode(password);
		int result = userRepository.update(id, password, profile);
		
		if(result == 1) { // 수정 성공
			User user = userRepository.findById(id);
			session.setAttribute("principal", user);
			principal.setProfile(user.getProfile());
			principal.setPassword(user.getPassword());
			return 1;
		}else { // 수정 실패
			return -1;
		}
	}
	

	
}