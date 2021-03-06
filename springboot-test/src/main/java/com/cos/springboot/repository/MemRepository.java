package com.cos.springboot.repository;

import java.util.List;

import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.model.Mem;

// MapperScan에 의해서 메모리에 로드됨. <-컴포넌트 스캔될때 컨피규레이션이 되니까 데이터엑세스콘픽파일보면
public interface MemRepository {
	// 전체보기
	List<Mem> findAll();
	// 상세보기
	Mem findById(int id);
	// 회원가입
	int save(RequestMemJoinDto dto);
	// 회원수정
	int update(RequestMemUpdateDto dto);
	// 회원삭제
	int delete(int id);
}
