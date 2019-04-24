package com.target.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.target.dto.ProductDto;
import com.target.service.ProductService;

@Controller
@RequestMapping("/product")
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
	@PostMapping(value = { "/search" })
	public void searchProduct(@ModelAttribute("productDto")final ProductDto productDto) {
		System.out.println(productDto);
	}
}
