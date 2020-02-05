package com.cos.goods.repository;

import java.util.List;

import com.cos.goods.dto.ReqProInsertDto;
import com.cos.goods.dto.ReqProUpdateDto;
import com.cos.goods.model.Pro;

public interface ProRepository {
	// 전체보기
	List<Pro> findAll();
	// 상세보기
	Pro findById(int id);
	// 상품입력
	int save(ReqProInsertDto dto);
	// 상품수정
	int update(ReqProUpdateDto dto);
	//  상품삭제
	int delete(int id);
	// 상품별
	List<Pro> findByType(String type);
	// 정렬
	List<Pro> findBySort(String sort);
	// 주문별
	List<Pro> findByOrdercount();
	// 가격별
	List<Pro> findByPrice();
	// 가격 과 타입
	List<Pro> findByPriceType(String type);
	// 주문 과 타입
	List<Pro> findByOrderType(String type);
	
}