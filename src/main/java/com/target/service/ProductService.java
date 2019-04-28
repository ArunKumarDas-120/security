package com.target.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.target.constants.TargetConstnats;
import com.target.dao.ProductRepo;
import com.target.dto.ProductDto;
import com.target.entity.ProductEntity;
import com.target.util.BeanConverter;

@Service
public class ProductService {

	private final ProductRepo productRepo;

	public ProductService(final ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public Map<String, String> addProduct(final ProductDto productDto) {
		Map<String, String> result = new HashMap<>();
		try {
			productRepo.save(BeanConverter.mapObject(productDto, ProductEntity.class));
			result.put(TargetConstnats.SCUCCESS, "Product Added..");
		} catch (Exception e) {
			result.put(TargetConstnats.ERROR, "Fail to save. System issue");
		}
		return result;
	}

	public void updateProduct(final ProductDto productDto) {
		productRepo.save(BeanConverter.mapObject(productDto, ProductEntity.class));
	}

}
