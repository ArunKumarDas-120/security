package com.target.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.target.dto.ProductDto;
import com.target.service.ProductService;

@Controller("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	@PostMapping(value = { "/add" })
	@PreAuthorize("hasAuthority('Admin')")
	public void addProduct(final ProductDto productDto) {
		productService.addProduct(productDto);
	}

	@PostMapping(value = { "/update" })
	@PreAuthorize("hasAuthority('Admin')")
	public void updateProduct(final ProductDto productDto) {
		productService.updateProduct(productDto);
	}

}
