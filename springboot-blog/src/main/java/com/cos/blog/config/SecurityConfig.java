package com.cos.blog.config;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cos.blog.model.RespCM;
import com.cos.blog.service.MyUserdetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// 시큐리티콘픽은 필터랑 인터셉터 사이 실행됨
	// 빈을 붙이면 메소드에 붙일수 있다. 빈을 하면 스프링이 관리한다 오토와이어드 해서 쓰면된다.
	// 해시는 복호화 안되는 암호
	// 만약 static 붙이면 충돌나니까 싱크로나이즈드 하면 대기열이 늘어나서 엄청느려진다. 
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
				.antMatchers("/user/profile/**","/post/write/**","/post/detail/**","/post/update/**","/post/delete/**").authenticated()
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
				.anyRequest().permitAll()
		.and()
		  		.formLogin()
		        .loginPage("/user/login")
		  	    .loginProcessingUrl("/user/loginProc") // post만 낚아챔
		  	    .successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						System.out.println(authentication.getName());
						System.out.println("성공함~~~~~~~~~");
						PrintWriter out = response.getWriter();
						
						ObjectMapper mapper = new ObjectMapper();
						// String 으로 저장
						String jsonString =mapper.writeValueAsString(new RespCM(200,"0k"));
						System.out.println("jsonString:" +jsonString);
						out.print(jsonString);
						out.flush();
						System.out.println(authentication);
						
					}
					
				})
		  	    .failureHandler(new AuthenticationFailureHandler() {
					
					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						// TODO Auto-generated method stub
						System.out.println(exception.getMessage());
					
						System.out.println("실패함~~~~~~~~~");
						PrintWriter out = response.getWriter();
						
						ObjectMapper mapper = new ObjectMapper();
						// String 으로 저장
						String jsonString =mapper.writeValueAsString(new RespCM(400,"fail"));
						System.out.println("jsonString:" +jsonString);
						out.print(jsonString);
						out.flush();
			
					}
				});// defaultSuccessUrl을 사용할 수 있음.		
	}
	
	@Autowired
	private UserDetailsService UserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailsService).passwordEncoder(encode());
	}
	
}
