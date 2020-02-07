package com.cos.blog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 백종원 = 어댑터 패턴
// 지금까지 배운어노테이션이 @Controller, @Configulation, @Service, @Repository
// @Component 아직 안배움 <- 특정파일 아니고 특별히 뭘로 지정할지 모르겟을때 컴포넌트 되있는거 메모리 다띄워줌
// 											  di받아서 주입하면됨, 싱글턴으로 객체를 띄우고 싶을때
public class SessionIntercepter extends HandlerInterceptorAdapter{
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {

				HttpSession session = request.getSession();
				if(session.getAttribute("principal") == null) {
							System.out.println("인증 안됐어 너 나가!!");
							response.sendRedirect("/user/login");
							return false;
				}
				System.out.println("인증 되셨습니다.");
				return true;
			}
}
