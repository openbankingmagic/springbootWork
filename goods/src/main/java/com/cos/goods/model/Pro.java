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
	private int orderCount; 
	private String type;
	
	@Builder
	public Pro(int id, String name, int price, int orderCount, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.orderCount = orderCount;
		this.type = type;
	}
}
