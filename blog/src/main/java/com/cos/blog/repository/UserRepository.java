package com.cos.blog.repository;

import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.model.user.dto.ReqLoginDto;

// MapperScan에 의해서 메모리에 로드됨. <-컴포넌트 스캔될때 컨피규레이션이 되니까 데이터엑세스콘픽파일보면
public interface UserRepository {

	int save(ReqJoinDto dto);

	int findByUsername(String username);

	User findByUsernameAndPassword(ReqLoginDto dto);
}
