package com.aakashkumar.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aakashkumar.microservices.controllers.dto.ProductPriceDto;
import com.aakashkumar.microservices.controllers.utils.ModelMapperUtils;
import com.aakashkumar.microservices.db.services.PricingService;


@RestController
@RequestMapping("/v1/prices")
public class PricingController {

	@Autowired ModelMapperUtils modelMapperUtils;
	@Autowired PricingService pricingService;

	@GetMapping("/")
	public List<ProductPriceDto> getPrices(@RequestParam List<Long> productIds) {
		return modelMapperUtils.mapEntityToDto(pricingService.getPrices(productIds), ProductPriceDto.class);
	}
}
