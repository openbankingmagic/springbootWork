package com.cos.baseball.repository;

import java.util.List;

import com.cos.baseball.model.Team;



public interface TeamRepository {

	// 전체보기
	List<Team> findAll();
}
