package com.aakashkumar.microservices.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductPriceDto {

	private long id;
	private long productId;
	private float listPrice;

}