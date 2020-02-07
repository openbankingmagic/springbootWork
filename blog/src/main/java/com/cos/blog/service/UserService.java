package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// 트랜잭션은 일의 순서를 만들어놓고 순서대로 처리하는거 커밋이나 롤백처리 throw new RuntimeException()해줘야
	@Transactional
	public int 회원가입(ReqJoinDto dto) {		
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			
			if(result == 1){
				return ReturnCode.아이디중복;
			}else {
				return userRepository.save(dto);
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public User 로그인(ReqLoginDto dto) {
		return userRepository.findByUsernameAndPassword(dto);
	}
	
}
