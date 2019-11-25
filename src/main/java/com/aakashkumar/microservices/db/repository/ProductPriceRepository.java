
package com.aakashkumar.microservices.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.aakashkumar.microservices.db.entity.ProductPrice;

public interface ProductPriceRepository extends CrudRepository<ProductPrice, Float> {

    List<ProductPrice> findByProductIdIn(List<Long> productIds);
}
