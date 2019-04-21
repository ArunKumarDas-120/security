package com.target.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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

	@Transactional
	public void addProduct(final ProductDto productDto) {
		productRepo.save(BeanConverter.mapObject(productDto, ProductEntity.class));
	}
	@Transactional
	public void updateProduct(final ProductDto productDto) {
		productRepo.save(BeanConverter.mapObject(productDto, ProductEntity.class));
	}
	
}
