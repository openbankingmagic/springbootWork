package com.cos.goods.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqProDto {
	
	private ResDto dto;
	
	private String name;
	
	private int price;
	
	private int ordercount;
	
	private String type;
}
