
package com.aakashkumar.microservices.db.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aakashkumar.microservices.db.entity.ProductPrice;
import com.aakashkumar.microservices.db.repository.ProductPriceRepository;

@Service
public class PricingService {

    @Value("${records-size}") Integer recordsSize;    
    @Autowired ProductPriceRepository productPriceRepository;

    public List<ProductPrice> getPrices(List<Long> productIds) {
        List<ProductPrice> data= productPriceRepository.findByProductIdIn(productIds);
        
        return (data!=null)? data: new ArrayList<>();
    }
}