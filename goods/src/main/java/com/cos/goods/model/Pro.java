package com.cos.goods.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pro {
	private int id;
	private String name;
	private int price;
	private int ordercount;
	private String type;
	
	@Builder
	public Pro(int id, String name, int price, int ordercount, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.ordercount = ordercount;
		this.type = type;
	}
}
