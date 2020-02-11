package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.user.User;
import com.cos.blog.repository.UserRepository;

@Service
public class MyUserdetailService implements UserDetailsService{

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("진입 loadUserByUsername");
		
		User user = UserRepository.authentication(username);
		

		// get방식으로 user/login 페이지 하면 안탄다 포스트방식으로 하면 시큐리티 콘픽의 프로세스유알엘에 걸린다.
		// db랑 유효한지 확인하고 토큰만들고 어선티 케이션한태 주고 프로바이더는 패스워드는 따로 신경안써도 되고 유저네임만 던져준다
		// 로드유저바이유저네임으로 던져준다 메모리에 올라잇다 @서비스해 잇으니
		// 실제 유저 정보를 셀렉트해서 유저디테일을 상속한 유저가 리턴한다 
		// 어서티케이션을 스프링시큐리티 컨택스트를 키값으로 가져간다 . 세션안에 스프링시큐리티 컨택스트가 있다.
		if(user == null) {
			throw new UsernameNotFoundException("해당 유저가 없습니다.");
		}
		
		return user;
	}

}
