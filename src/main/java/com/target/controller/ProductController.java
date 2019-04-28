package com.target.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.target.dto.ProductDto;
import com.target.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	@ResponseBody
	@PostMapping(value = { "/add" } , produces = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasAuthority('Admin')")
	public Map<String, String> addProduct(@ModelAttribute("productDto") final ProductDto productDto) {
		return productService.addProduct(productDto);
	}

	@PostMapping(value = { "/update" })
	@PreAuthorize("hasAuthority('Admin')")
	public void updateProduct(@ModelAttribute("productDto") final ProductDto productDto) {
		productService.updateProduct(productDto);
	}

	@PostMapping(value = { "/search" })
	public void searchProduct(@ModelAttribute("productDto") final ProductDto productDto) {
		System.out.println(productDto);
	}
}
