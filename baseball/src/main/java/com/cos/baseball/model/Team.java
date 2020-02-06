package com.cos.baseball.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Team {
	private int id;
	private String teamname;
	private Timestamp createDate;
	
	@Builder
	public Team(int id, String teamname, Timestamp createDate) {
		this.id = id;
		this.teamname = teamname;
		this.createDate = createDate;
	}
	
	
}
