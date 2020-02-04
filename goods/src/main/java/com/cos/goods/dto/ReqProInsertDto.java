package com.cos.goods.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqProInsertDto {
	
	
	private ResDto dto;
	
	@NotBlank(message = "상품명이 입력되지 않았습니다.")
	private String name;
	@NotBlank(message = "상품 가격이 입력되지 않았습니다.")
	private int price;
	@NotBlank(message = "상품 수량이 입력되지 않았습니다.")
	private int ordercount;
	@NotBlank(message = "상품타입이 입력되지 않았습니다.")
	private String type;
}
